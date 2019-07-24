//package com.codeup.trainingapp.Controllers;
//
//import com.codeup.trainingapp.Repositories.UserRepository;
//import com.codeup.trainingapp.models.Needs.User;
//import org.springframework.http.MediaType;
//import org.springframework.http.ResponseEntity;
//import org.springframework.web.bind.annotation.RequestMapping;
//import org.springframework.web.bind.annotation.RequestParam;
//import org.springframework.web.bind.annotation.ResponseBody;
//import org.springframework.web.bind.annotation.RestController;
//
//
//@RestController
//public class RestCoordinator {
//
//    private UserRepository userDao;
//
//    public RestCoordinator(UserRepository userDao) {
//        this.userDao = userDao;
//    }
//
//    @RequestMapping(value="/makeInstructor",
//    produces = MediaType.APPLICATION_JSON_VALUE)
//    public User makeInstructor(@RequestParam(required = false) Long emp_id) {
//        User user = userDao.findOne(emp_id);
//        user.setRole("instructor");
//        System.out.println("got here! " + user.getFirst_name());
//        return userDao.save(user);
//    }
//}
