package controllers;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.ModelAndView;

import data.MPG;
import data.MPGDAO;

@Controller
public class MPGController
{
	@Autowired
	private MPGDAO mpgDao;

	@ResponseBody
	@RequestMapping("ping")
	public String ping()
	{
		return "pong";
	}

	@ResponseBody
	@RequestMapping(path = "getData")
	public List<MPG> getData()
	{
		List<MPG> list = mpgDao.getData();
		// System.out.println(list);
		ModelAndView mv = new ModelAndView();
		mv.setViewName("../result.jsp");
		mv.addObject("object", list);
		return list;
	}

	@ResponseBody
	@RequestMapping(path = "getData/{id}")
	public MPG start(@PathVariable int id)
	{
		MPG mpg = mpgDao.getById(id);
		return mpg;
	}

	// mine
	@ResponseBody
	@RequestMapping(path = "mpg", method = RequestMethod.PUT)
	public Boolean createMPG(@RequestBody MPG emp)
	{
		System.out.println(emp);
		return mpgDao.createMPG(emp);
	}

	@ResponseBody
	@RequestMapping(path = "mpg/{id}", method = RequestMethod.POST)
	public Boolean updateMPG(@PathVariable int id, @RequestBody MPG emp)
	{
		System.out.println(emp);
		System.out.println("update");
		return mpgDao.updateMPG(id, emp);
	}

	@ResponseBody
	@RequestMapping(path = "mpg/{id}", method = RequestMethod.DELETE)
	public Boolean deleteMPG(@PathVariable int id)
	{
		return mpgDao.deleteMPG(id);
	}

	// examples
//	@ResponseBody
//	@RequestMapping(path = "employee", method = RequestMethod.PUT)
//	public Boolean createEmployee(@RequestBody Employee emp)
//	{
//		System.out.println(emp);
//		return xhrDAO.createEmployee(emp);
//	}
//
//	@ResponseBody
//	@RequestMapping(path = "employee/{id}", method = RequestMethod.POST)
//	public Boolean createEmployee(@PathVariable int id, @RequestBody Employee emp)
//	{
//		System.out.println(emp);
//		return xhrDAO.updateEmployee(id, emp);
//	}
//
//	@ResponseBody
//	@RequestMapping(path = "employee/{id}", method = RequestMethod.DELETE)
//	public Boolean deleteEmployee(@PathVariable int id)
//	{
//		return xhrDAO.deleteEmployee(id);
//	}

	// @ResponseBody
	// @RequestMapping(path="start/{text}")
	// public MPG start(@RequestParam("text") String text)
	// {
	// MPG m = new MPG("California", 1000, 50, 1.49);
	// return m;
	// }

	// @ResponseBody
	// @RequestMapping(path="start/{text}")
	// public List<MPG> start(@PathVariable("text") String text)
	// {
	// List<MPG> list = mpgDao.getData();
	// MPG m = new MPG("California", 1000, 50, 1.49);
	// return list;
	// }

	// @ResponseBody
	// @RequestMapping(path="start/{text}", params = "text", method =
	// RequestMethod.GET)
	// public ModelAndView start(@RequestParam("text") String text)
	// {
	// ModelAndView mv = new ModelAndView();
	// mv.setViewName("../start.jsp");
	// mv.addObject("result", text);
	// return mv;
	// }
}
