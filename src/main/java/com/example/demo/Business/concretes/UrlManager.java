package com.example.demo.Business.concretes;

import com.example.demo.Business.abstracts.UrlService;
import com.example.demo.Core.entities.concretes.User;
import com.example.demo.Core.utilities.results.*;
import com.example.demo.DataAccess.abstracts.concretes.UrlDao;
import com.example.demo.Entities.concretes.Url;
import com.example.demo.Entities.dtos.UrlDeleteDto;
import com.example.demo.Entities.dtos.UrlDto;
import com.example.demo.Entities.dtos.UrlListDto;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.time.LocalDate;
import java.util.List;
import java.util.UUID;

@Service
public class UrlManager implements UrlService {

    private UrlDao urlDao;

    @Autowired
    public UrlManager(UrlDao urlDao) {
        this.urlDao = urlDao;
    }

    @Override
    public DataResult<List<UrlListDto>> getUrlFindByUserId(Long userId) {
        return new SuccessDataResult<>(this.urlDao.getUrlFindByUserId(userId));
    }

    @Override
    public DataResult<List<Url>> getUrlList() {
        return new SuccessDataResult<>(this.urlDao.findAll(),"listelendi");
    }

    @Override
    public DataResult<Url> getUrl(Long id) {
        Url url = urlDao.findById(id).get();
        if (url != null){
            return new SuccessDataResult<>(url);
        }
        return  new ErrorDataResult<>();

    }

    @Override
    public DataResult<Url> getShortUrl(String shortUrl) {
        return new SuccessDataResult<>(this.urlDao.getByShortUrl(shortUrl));
    }

    @Override
    public DataResult<String> redirectUrl(String shortUrl) {
        var result = getShortUrl(shortUrl).getData().getUrl();
        if(result.contains("https://")){
            result = result.replaceAll("https://","");
        }
        else {
            result = result.replaceAll("http://","");
        }
        return new SuccessDataResult<>(result, "url");
    }

    @Override
    public DataResult<Url> urlAdd(UrlDto urlDto) {
       if (!urlDto.getUrl().isEmpty()){
        Url url = new Url();
        url.setUrl(urlDto.getUrl());
        url.setShortUrl(UUID.randomUUID().toString());
        url.setLocalDate(LocalDate.now());
        User user = new User();
        user.setId(urlDto.getUserId());
        url.setUser(user);

        return new SuccessDataResult<>(this.urlDao.save(url));
       }
       else
           return new ErrorDataResult<>("Lütfen boş tıklama");
    }

    @Override
    public Result urlDelete(UrlDeleteDto deleteDto) {
        var url = getUrl(deleteDto.getUrlId()).getData();
        if(url.getUser().getId() == deleteDto.getUserId()){
            this.urlDao.deleteById(deleteDto.getUrlId());
            return new SuccessResult();
        }
        return new ErrorResult();
    }
}
