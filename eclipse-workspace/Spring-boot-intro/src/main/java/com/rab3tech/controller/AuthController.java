/*
 * package com.rab3tech.controller;
 * 
 * import java.sql.Date; import java.util.List;
 * 
 * import javax.servlet.http.HttpServletRequest;
 * 
 * import org.springframework.beans.factory.annotation.Autowired; import
 * org.springframework.stereotype.Controller; import
 * org.springframework.ui.Model; import
 * org.springframework.web.bind.annotation.GetMapping; import
 * org.springframework.web.bind.annotation.ModelAttribute; import
 * org.springframework.web.bind.annotation.PostMapping; import
 * org.springframework.web.bind.annotation.RequestParam;
 * 
 * import com.rab3tech.service.SignupService;
 * 
 * //This is controller
 * 
 * @Controller public class AuthController {
 * 
 * 
 * public static void main(String[] args) { java.util.Date date=new
 * java.util.Date(1605809787035L); System.out.println(date);
 * 
 * java.util.Date edate=new java.util.Date(1605804387035L);
 * System.out.println(edate); }
 * 
 * @Autowired private SignupService signupService;
 * 
 * @PostMapping("changePassword") public String changePasswordPost(int
 * sid,String newPassword, String confirmPassword, Model model) {
 * if(!newPassword.equals(confirmPassword)){ SignUp
 * signUp=signupService.findById(sid); //Adding data into request scope
 * model.addAttribute("signUp", signUp); model.addAttribute("message",
 * "Your new password and confirm password are not same!"); return "chpassword";
 * } // Below is spring jdbc programming
 * signupService.updatePassword(sid,newPassword); return
 * "redirect:/auth?message=Your password is updated successfully"; }
 * 
 * @GetMapping("changePassword") public String
 * showChangePasswordPage(@RequestParam("sid") int sid,Model model) { //Below is
 * spring jdbc programming SignUp signUp=signupService.findById(sid); //Adding
 * data into request scope model.addAttribute("signUp", signUp); return
 * "chpassword";// chpassword.jsp }
 * 
 * //This action will show all the signups data over jsp
 * 
 * @GetMapping("deleteSignup") public String deleteSignup(HttpServletRequest
 * request,Model model) { //Below code will delete the record as sid passed from
 * html page String sid = request.getParameter("sid");
 * signupService.delete(sid); //below is redirecting request to the new action
 * return "redirect:/psignups";// //Redirect means do not go to the jsp //go to
 * action psignups }
 * 
 * 
 * //This action will show all the signups data over jsp
 * 
 * @GetMapping("psignups") public String showSignups(Model model) { //Below is
 * spring jdbc programming List<SignUp> signUps=signupService.findAll();
 * //Adding data into request scope model.addAttribute("pkpksignUps", signUps);
 * return "signups";// signups.jsp }
 * 
 * 
 * 
 * // method =GET // action=auth
 * 
 * @GetMapping("signup") public String signupUser() { return "usignup";//
 * login.jsp }
 * 
 * @PostMapping("signup") public String signupPost(@ModelAttribute SignUp
 * signUp,Model model) { //1. accessing parameters from request scope as per
 * attributes of the class //2. I will create an instance of SignUp //3. setting
 * all the request parameter values inside SignUp object
 * signupService.save(signUp); System.out.println(signUp); //signUp object we
 * are adding into request scope //so that we can access this object on jsp page
 * model.addAttribute("signUp", signUp); model.addAttribute("message",
 * "<span style=\"color:blue\">You have signed up successfully!!!!!!!!</span>");
 * return "login";// login.jsp }
 * 
 * 
 * //method =POST //action=auth
 * 
 * @PostMapping("/auth") public String authUser(@RequestParam String
 * username,@RequestParam String password,Model model) { //Below is spring jdbc
 * programming List<SignUp> signUps=signupService.authUser(username, password);
 * if (signUps.size()>0) { model.addAttribute("message",
 * "<span style=\"color:green\">You are great!!!!!!!!</span>"); } else {
 * model.addAttribute("message",
 * "<span style=\"color:red\">You are not great!!!!!!!</span>"); } return
 * "login"; //// login.jsp }
 * 
 * //method =GET //action=auth
 * 
 * @GetMapping({"/auth","/"}) public String getAuthUser() { return "login";//
 * login.jsp }
 * 
 * }
 */