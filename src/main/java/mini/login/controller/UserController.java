package mini.login.controller;

import lombok.RequiredArgsConstructor;
import mini.login.domain.SiteUser;
import mini.login.service.UserService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequiredArgsConstructor
public class UserController {

    private final UserService userService;

//    @PostMapping("/signUp")
//    @ResponseStatus(HttpStatus.OK)
//    public void signUp(@RequestBody String email, String password, String nickname) throws Exception {
//        userService.signUp(email, password, nickname);
//    }

    @PostMapping("/api/sign-up")
    public ResponseEntity<String> signUp(@RequestParam("email") String email,
                                         @RequestParam("nickname") String nickname,
                                         @RequestParam("password") String password) {
        ResponseEntity<String> res = null;
        try {
            userService.signUp(email, nickname, password);
            res = new ResponseEntity<String>("회원가입 성공", HttpStatus.OK);
        } catch (Exception e) {
            e.printStackTrace();
            res = new ResponseEntity<String>("회원가입 실패", HttpStatus.BAD_REQUEST);
        }
        return res;
    }
}
