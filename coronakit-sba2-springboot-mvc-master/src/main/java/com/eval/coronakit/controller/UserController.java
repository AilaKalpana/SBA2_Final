package com.eval.coronakit.controller;

import java.time.LocalDate;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

import com.eval.coronakit.Exception.CkException;
import com.eval.coronakit.entity.CoronaKit;
import com.eval.coronakit.entity.KitDetail;
import com.eval.coronakit.entity.ProductMaster;
import com.eval.coronakit.service.CoronaKitService;
import com.eval.coronakit.service.KitDetailService;
import com.eval.coronakit.service.ProductService;

@Controller
@RequestMapping("/user")
public class UserController {
	
	@Autowired
	ProductService productService;
	
	@Autowired
	CoronaKitService coronaKitService;
	
	@Autowired
	KitDetailService kitDetailService;
	
	@RequestMapping("/home")
	public String home() {
		System.out.println("**********************home controller");
		return "user-home";
		
	}
	
	@RequestMapping("/show-kit")
	public String showKit(Model model) throws CkException {
		
		model.addAttribute("kitDetails", kitDetailService.getAll());
		return "show-cart";
	}

	@RequestMapping("/show-list")
	public String showList(ModelMap model) throws CkException {
		
		model.addAttribute("productMasters",  productService.getAllProducts());
		
		return "show-all-item-user";
	}
	
	@RequestMapping("/add-to-cart/{productId}")
	public String showKit(@PathVariable("productId") int productId, ModelMap model) throws CkException {
		ProductMaster productMaster = productService.getProductById(productId);
		KitDetail kitdetail = new KitDetail();
		kitdetail.setProductId(productMaster.getId());
		kitdetail.setQuantity(1);
		kitdetail.setAmount(productMaster.getCost());
		kitDetailService.addKitItem(kitdetail);
		model.addAttribute("productMasters",  productService.getAllProducts());
		return "show-all-item-user";
	}
	
	@RequestMapping("/checkout")
	public String checkout(@RequestParam String address,@RequestParam String amount,  Model model) throws CkException {
		CoronaKit coronaKit = new CoronaKit();
		coronaKit.setOrderDate(LocalDate.now().toString());
		coronaKit.setDeliveryAddress(address);
		coronaKit.setTotalAmount(Integer.parseInt(amount));
		model.addAttribute("coronaKit", coronaKitService.saveKit(coronaKit));
		return "checkout-address";
	}
	
	@RequestMapping("/finalize")
	public String finalizeOrder(String address,Model model) {
		return null;
	}
	
	@RequestMapping("/delete/{itemId}")
	public String deleteItem(@PathVariable("itemId") int itemId,  Model model) throws CkException {
		kitDetailService.deleteByProdId(itemId);
		model.addAttribute("kitDetails", kitDetailService.getAll());
		model.addAttribute("msg",  "Item is deleted!");
		return "show-cart";
		
	}
}
