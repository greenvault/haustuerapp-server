package de.gruene.haustuer.user;

import javax.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController()
@RequestMapping("/user")
public class UserController {

    @Autowired
    private UserService userService;

    @PostMapping("confirm")
    public ResponseEntity<User> confirmUser(@Valid @RequestBody final User user) {
        final boolean succeeded = this.userService.confirm(user);
        return succeeded ? new ResponseEntity<>(HttpStatus.ACCEPTED)
                : new ResponseEntity<>(HttpStatus.CONFLICT);
    }

    @PostMapping
    public ResponseEntity<User> createUser(@Valid @RequestBody final User user) {
        final boolean succeeded = this.userService.create(user);
        return succeeded ? new ResponseEntity<>(HttpStatus.ACCEPTED)
                : new ResponseEntity<>(HttpStatus.CONFLICT);
    }

}
