package com.example.demo.Controllers;

import com.example.demo.Business.abstracts.UrlService;
import com.example.demo.Entities.dtos.UrlDeleteDto;
import com.example.demo.Entities.dtos.UrlDto;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.view.RedirectView;

import javax.websocket.server.PathParam;

@CrossOrigin
@RestController
@RequestMapping(path = "api/v1/url/")
public class UrlsController {

    private final UrlService urlService;

    @Autowired
    public UrlsController(UrlService urlService) {
        this.urlService = urlService;
    }


    @GetMapping(path = "/getUrlFindByUserId/{userId}")
    public ResponseEntity<?> getUrlFindByUserId(@PathVariable("userId") Long userId){
        var result = this.urlService.getUrlFindByUserId(userId);
        if (result.isSuccess()){
            return new ResponseEntity<>(result,HttpStatus.OK);
        }
        return  new ResponseEntity<>(result,HttpStatus.BAD_REQUEST);
    }

    @GetMapping(path = "/getshortUrl/{shortUrl}")
    public ResponseEntity<?> getshortUrl(@PathVariable("shortUrl") String shortUrl){
        var result = this.urlService.getShortUrl(shortUrl);
        if (result.isSuccess()){
            return new ResponseEntity<>(result,HttpStatus.OK);
        }
        return  new ResponseEntity<>(result,HttpStatus.BAD_REQUEST);
    }


    @GetMapping(path = "/geturllist")
    public ResponseEntity<?> getUrlList(){
        var result = this.urlService.getUrlList();
        if (result.isSuccess()){
            return new ResponseEntity<>(result,HttpStatus.OK);
        }
        return  new ResponseEntity<>(result,HttpStatus.BAD_REQUEST);
    }

    @GetMapping(path = "{urlId}")
    public ResponseEntity<?> getUrlFindById(@PathVariable("urlId") Long id){
        var result = urlService.getUrl(id);
        if (result.isSuccess()){
            return  new ResponseEntity<>(result ,HttpStatus.OK);
        }
        return  new ResponseEntity<>(HttpStatus.NO_CONTENT);
    }

    @GetMapping(path = "redirect/{shortUrl}")
    public RedirectView redirectUrl(@PathVariable("shortUrl") String shortUrl){
        var result = urlService.redirectUrl(shortUrl);
        RedirectView redirectView = new RedirectView();
        if (result.isSuccess()){
            redirectView.setUrl("https://"+result.getData());
            return redirectView;
        }
        return null;
    }

    @PostMapping(path = "/addUrl")
    public ResponseEntity<?> addUrl(@RequestBody UrlDto urlDto){
        var result = urlService.urlAdd(urlDto);
        if (result.isSuccess()){
            return  new ResponseEntity<>(result ,HttpStatus.OK);
        }
        return  new ResponseEntity<>(HttpStatus.NO_CONTENT);
    }

    @DeleteMapping(path = "/deleteUrl")
    public ResponseEntity<?> deleteUrl(@RequestBody UrlDeleteDto deleteDto){
        var result = urlService.urlDelete(deleteDto);
        if (result.isSuccess()){
            return  new ResponseEntity<>(result ,HttpStatus.OK);
        }
        return  new ResponseEntity<>(HttpStatus.FORBIDDEN);
    }
}
