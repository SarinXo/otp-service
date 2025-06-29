package sarinxo.otpservice.controller;

import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;
import sarinxo.otpservice.dto.CheckRequest;
import sarinxo.otpservice.dto.GenerateRequest;
import sarinxo.otpservice.dto.common.RequestWrapper;

@Slf4j
@RestController
@RequiredArgsConstructor
public class OtpController {

    @PostMapping("/generateAndSend")
    public void generateAndSend(@RequestBody @Valid RequestWrapper<GenerateRequest> request) {

    }

    @PostMapping("/check")
    public void check(@RequestBody @Valid RequestWrapper<CheckRequest> request) {

    }

}
