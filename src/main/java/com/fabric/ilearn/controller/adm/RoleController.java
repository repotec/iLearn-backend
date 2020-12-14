package com.fabric.ilearn.controller.adm;

import com.fabric.ilearn.service.adm.RoleService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/role")
public class RoleController {
    @Autowired
    RoleService roleService;

    @RequestMapping(method = RequestMethod.GET)
    public ResponseEntity<?> getAllRoles(@RequestHeader(value = "Accept-Language", defaultValue = "ar", required = false) String localeCode){
        return new ResponseEntity<>(roleService.findAllRoleByLocaleCode(localeCode), HttpStatus.OK);
    }
}
