package lexicon.task;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

@Controller
public class MainController {
	@Autowired
	public OrderRepository orderRepository;

	@RequestMapping("/")
	public String home() {
		return "home";
	}

	@RequestMapping("/kitchen_view")
	public String KV(Model model) {
		model.addAttribute("db_entries", orderRepository.findAll());
		model.addAttribute("helper", new OrderHelper());
		return "kitchen_view";
	}

	@RequestMapping("/menu")
	public String menu() {
		return "menu";
	}

	@GetMapping("/order")
	public String orderForm(Order order, Model model) {
		model.addAttribute("helper", new OrderHelper());
		return "order";
	}

	@PostMapping("/order")
	public String handleOrder(@Valid Order order, BindingResult bindingResult,
			Model model, @RequestParam Long id) {
		if (bindingResult.hasErrors()) {
			model.addAttribute("helper", new OrderHelper());
			return "order";
		}
		if (id != -1)
			orderRepository.delete(id);
		orderRepository.save(order);
		return "redirect:/kitchen_view";
	}

	@RequestMapping("/edit")
	public String editOrder(Order order, BindingResult bindingResult,
			Model model, @RequestParam Long id) {
		model.addAttribute("db_entry", orderRepository.findOne(id));
		model.addAttribute("helper", new OrderHelper());
		return "order";
	}

	@RequestMapping("/delete")
	public String deleteOrder(@RequestParam Long id) {
		orderRepository.delete(id);
		return "redirect:/kitchen_view";
	}

	@RequestMapping("/finish")
	public String finishOrder(Model model, @RequestParam Long id) {
		model.addAttribute("db_entry", orderRepository.findOne(id));
		model.addAttribute("helper", new OrderHelper());
		orderRepository.delete(id);
		return "receipt";
	}
}
