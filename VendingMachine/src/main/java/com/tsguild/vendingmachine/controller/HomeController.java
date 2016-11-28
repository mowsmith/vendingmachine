package com.tsguild.vendingmachine.controller;

import com.tsguild.vendingmachine.dao.VendingMachineDao;
import com.tsguild.vendingmachine.dto.InventoryItem;
import java.util.List;
import javax.inject.Inject;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.ResponseStatus;

@Controller
public class HomeController {
    
    private VendingMachineDao dao;
    
    @Inject
    public HomeController(VendingMachineDao dao) {
        this.dao = dao;
    }
    
    @RequestMapping(value = {"/", "/home"}, method = RequestMethod.GET)
    public String displayHomePage() {
        return "home";
    }
    
    @RequestMapping(value = "/items", method = RequestMethod.GET)
    @ResponseBody
    public List<InventoryItem> getAllItems() {
        return dao.getAllInventoryItems();
    }
    
    @RequestMapping(value = "/item/{id}", method = RequestMethod.PUT)
    @ResponseStatus(HttpStatus.NO_CONTENT)
    public void subtractItem(@PathVariable("id") int id, @RequestBody InventoryItem item) {
        item.setId(id);
        dao.updateInventoryItem(item);
    }
}