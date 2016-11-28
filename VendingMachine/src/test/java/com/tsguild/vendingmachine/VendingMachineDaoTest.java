package com.tsguild.vendingmachine;

import com.tsguild.vendingmachine.dao.VendingMachineDao;
import com.tsguild.vendingmachine.dto.InventoryItem;
import java.util.List;
import org.junit.After;
import org.junit.AfterClass;
import org.junit.Assert;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;
import org.springframework.jdbc.core.JdbcTemplate;

/**
 *
 * @author Morgan Smith
 */
public class VendingMachineDaoTest {

    VendingMachineDao testObj;

    public VendingMachineDaoTest() {
    }

    @BeforeClass
    public static void setUpClass() {
    }

    @AfterClass
    public static void tearDownClass() {
    }

    @Before
    public void setUp() {
        ApplicationContext ctx = new ClassPathXmlApplicationContext("test-applicationContext.xml");
        testObj = ctx.getBean("jdbcDao", VendingMachineDao.class);

        JdbcTemplate cleaner = (JdbcTemplate) ctx.getBean("jdbcTemplate");
        cleaner.execute("delete from Machine");
    }

    @After
    public void tearDown() {
    }

    @Test
    public void addGetDeleteInventoryItem() {

        // Create new item
        InventoryItem item = new InventoryItem();
        item.setName("Pepsi");
        item.setCost(.75);
        item.setNumberInInventory(3);

        testObj.addInventoryItem(item);

        InventoryItem fromDb = testObj.getInventoryItemById(item.getId());

        Assert.assertEquals(fromDb, item);

        testObj.removeInventoryItem(item.getId());

        Assert.assertNull(testObj.getInventoryItemById(item.getId()));
    }

    @Test
    public void addUpdateInventoryItem() {

        // Create new item
        InventoryItem item = new InventoryItem();
        item.setName("Pepsi");
        item.setCost(.75);
        item.setNumberInInventory(3);

        testObj.addInventoryItem(item);

        item.setName("Coke");

        testObj.updateInventoryItem(item);

        InventoryItem fromDb = testObj.getInventoryItemById(item.getId());

        Assert.assertEquals(fromDb, item);
    }

    @Test
    public void getAllInventoryItems() {

        // Create new item
        InventoryItem item = new InventoryItem();
        item.setName("Pepsi");
        item.setCost(.75);
        item.setNumberInInventory(3);

        testObj.addInventoryItem(item);

        InventoryItem item2 = new InventoryItem();
        item2.setName("Coke");
        item2.setCost(1.75);
        item2.setNumberInInventory(2);

        testObj.addInventoryItem(item2);

        List<InventoryItem> dList = testObj.getAllInventoryItems();
        Assert.assertEquals(2, dList.size());
    }
}
