
package com.tsguild.vendingmachine.dao;

import com.tsguild.vendingmachine.dto.InventoryItem;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.List;
import org.springframework.dao.EmptyResultDataAccessException;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.RowMapper;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

/**
 *
 * @author Morgan Smith
 */
public class VendingMachineDaoImpl implements VendingMachineDao {

    private JdbcTemplate jdbcTemplate;
    
    public void setJdbcTemplate(JdbcTemplate jdbcTemplate){
        this.jdbcTemplate = jdbcTemplate;
    }
    
     private static final String SQL_ADD_INVENTORYITEM = "insert into Machine (`name`, cost, numberInInventory) values (?, ?, ?)";

    @Override
    @Transactional(propagation = Propagation.REQUIRED, readOnly = false)
    public InventoryItem addInventoryItem(InventoryItem item) {
        jdbcTemplate.update(SQL_ADD_INVENTORYITEM, item.getName(), item.getCost(), item.getNumberInInventory());
        int id = jdbcTemplate.queryForObject("SELECT LAST_INSERT_ID()", Integer.class);
        item.setId(id);
        return item;
    }

    private static final String SQL_SELECT_INVENTORYITEM_BY_ID = "select * from Machine where id = ?";

    @Override
    public InventoryItem getInventoryItemById(int itemId) {
        try {
            return jdbcTemplate.queryForObject(SQL_SELECT_INVENTORYITEM_BY_ID, // select stmt
                    new InventoryItemMapper(), // what we're turning the RS into!
                    itemId); // and then subsitituting in any placeholders
        } catch (EmptyResultDataAccessException e) {
            return null;
        }
    }

    private static final String SQL_SELECT_ALL_INVENTORYITEMS = "select * from Machine";

    @Override
    public List<InventoryItem> getAllInventoryItems() {
        return jdbcTemplate.query(SQL_SELECT_ALL_INVENTORYITEMS, new InventoryItemMapper());
    }
    
     private static final String SQL_UPDATE_INVENTORYITEM_BY_ID = "update Machine set `name`= ?, cost = ?, numberInInventory = ? where id = ?";
    
    @Override
    public void updateInventoryItem(InventoryItem item) {
        jdbcTemplate.update(SQL_UPDATE_INVENTORYITEM_BY_ID, item.getName(), item.getCost(), item.getNumberInInventory(), item.getId());
    }

    private static final String SQL_REMOVE_INVENTORYITEM_BY_ID = "delete from Machine where id = ?";
    
    @Override
    public void removeInventoryItem(int itemId) {
        jdbcTemplate.update(SQL_REMOVE_INVENTORYITEM_BY_ID, itemId);
    }
    
    private static final class InventoryItemMapper implements RowMapper<InventoryItem> {

        @Override
        public InventoryItem mapRow(ResultSet rs, int rowNum) throws SQLException {
            InventoryItem item = new InventoryItem();
            String name = rs.getString("name");
            double cost = rs.getDouble("cost");
            int numberInInventory = rs.getInt("numberInInventory");
            int id = rs.getInt("id");

            item.setName(name);
            item.setCost(cost);
            item.setNumberInInventory(numberInInventory);
            item.setId(id);

            return item;
        }

    }
}
