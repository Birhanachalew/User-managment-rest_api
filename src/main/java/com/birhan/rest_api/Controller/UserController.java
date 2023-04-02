package com.birhan.rest_api.Controller;

import com.birhan.rest_api.Exception.ResourceNotFoundException;
import com.birhan.rest_api.Model.User;
import com.birhan.rest_api.Repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;

import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

@RestController
@RequestMapping("/api/v1")
public class UserController {
    @Autowired
    private UserRepository userRepository;
    @GetMapping("/users")//get all user list

    public List<User> getAllUsers(){
        return UserRepository.findAll();
    }// return the list
@GetMapping("/users/{id}")// get user by id
    public ResponseEntity<User> getUserById(@PathVariable(value = "id") Long userId)
 throws ResourceNotFoundException{
        User user = (User) userRepository.findById(userId).orElseThrow(() -> new ResourceNotFoundException("user not fou nd on : " + userId));
        return ResponseEntity.ok().body(user);}// return the user id throw RNF exception


    /*@PostMapping("/users")//create user
    public User createUser(@Valid@RequestBody User user){
    return UserRepository.save(user);}//return the user*/

@PutMapping("/users/{id}")//update user response entity @par of userId and userDetails
    public ResponseEntity<User> updateUser(
            @PathVariable(value = "id") Long UserId, @Validated@RequestBody User userDetails
) throws ResourceNotFoundException{
        User user = userRepository.findById(UserId).orElseThrow(() -> new ResourceNotFoundException("user not found : "+ UserId));
        user.setEmail(userDetails.getEmail());
        user.setLastName(userDetails.getLastName());
        user.
                setFirstName(userDetails.getFirstName());
        //user.setUpdateAt(new Date());
        final User updateUser = userRepository.save(user);
        return ResponseEntity.ok(updateUser);}//return response entity throws RNF exception



    @DeleteMapping("/user/{id}")//delete user map
    public Map<String , Boolean> deleteUser(@PathVariable(value = "id") Long userId) throws Exception{
        User user = (User) userRepository.findById(userId)
                .orElseThrow(() -> new ResourceNotFoundException("user not found on:" + userId));
        userRepository.delete((org.apache.catalina.User) user);
        //userRepository.delete((org.apache.catalina.User) user);
        Map<String , Boolean> response = new HashMap<>();
        response.put("deleted" , Boolean.TRUE);
        return response;//return map
    }

}
