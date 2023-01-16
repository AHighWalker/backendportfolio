
package com.miPortfolio.server.security.controller;

import com.miPortfolio.server.security.dto.JwtDTO;
import com.miPortfolio.server.security.dto.LoginUser;
import com.miPortfolio.server.security.dto.NewUser;
import com.miPortfolio.server.security.entity.Role;
import com.miPortfolio.server.security.entity.User;
import com.miPortfolio.server.security.enums.RoleName;
import com.miPortfolio.server.security.jwt.JwtProvider;
import com.miPortfolio.server.security.service.RoleService;
import com.miPortfolio.server.security.service.UserService;
import java.util.HashSet;
import java.util.Set;
import javax.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/auth")
@CrossOrigin
public class AuthController {
    
    @Autowired
    PasswordEncoder passwordEncoder;
    @Autowired
    AuthenticationManager authenticationManager;
    @Autowired
    UserService userService;
    @Autowired
    RoleService roleService;
    @Autowired
    JwtProvider jwtProvider;
    
    @PostMapping("/new")
    public ResponseEntity<?>  newUser(@Valid @RequestBody NewUser newUser, BindingResult bindingResult){
        if (bindingResult.hasErrors())
            return new ResponseEntity( new Message("Campos mal puestos o email invalido"),HttpStatus.BAD_REQUEST);
        
        if (userService.existsByUserName(newUser.getUserName()))
            return new ResponseEntity(new Message("Ese nombre de usuario ya existe"),HttpStatus.BAD_REQUEST);
        
        if (userService.existsByEmail(newUser.getEmail()))
            return new ResponseEntity(new Message("Ese email ya esta siendo utilizado"), HttpStatus.BAD_REQUEST);

        User user = new User(newUser.getName(),newUser.getUserName(),newUser.getEmail(),
                passwordEncoder.encode(newUser.getPassword()));
        
        Set<Role> roles = new HashSet<>();
            roles.add(roleService.getByRoleName(RoleName.ROLE_USER).get());
        
         if(newUser.getRoles().contains("admin"))
             roles.add(roleService.getByRoleName(RoleName.ROLE_ADMIN).get());
         
         user.setRoles(roles);
         userService.save(user);
         
         return new ResponseEntity(new Message("Usuario guardado"),HttpStatus.CREATED);
        
    }
    
    
    @PostMapping("/login")
    public ResponseEntity<JwtDTO> login(@Valid @RequestBody LoginUser loginUser, BindingResult bindingResult){
        if(bindingResult.hasErrors())
            return new ResponseEntity(new Message("Campos mal puestos"),HttpStatus.BAD_REQUEST);
        
        Authentication authentincation = authenticationManager.authenticate(new UsernamePasswordAuthenticationToken(
        loginUser.getUserName(), loginUser.getPassword()));
        
        SecurityContextHolder.getContext().setAuthentication(authentincation);
        
        String jwt = jwtProvider.generateToken(authentincation);
        
        UserDetails userDetails = (UserDetails) authentincation.getPrincipal();
        
        JwtDTO jwtDto = new JwtDTO(jwt, userDetails.getUsername(), userDetails.getAuthorities());
        
        return new ResponseEntity(jwtDto, HttpStatus.OK);
    }
    
}
