package com.example.demo.Business.abstracts;

import com.example.demo.Core.utilities.results.DataResult;
import com.example.demo.Core.utilities.results.Result;
import com.example.demo.Entities.concretes.Url;
import com.example.demo.Entities.dtos.UrlDeleteDto;
import com.example.demo.Entities.dtos.UrlDto;
import com.example.demo.Entities.dtos.UrlListDto;

import java.util.List;

public interface UrlService {

    DataResult<List<UrlListDto>> getUrlFindByUserId(Long userId);
    DataResult<List<Url>> getUrlList();
    DataResult<Url> getUrl(Long id);
    DataResult<Url> getShortUrl(String shortUrl);
    DataResult<String> redirectUrl(String shortUrl);
    DataResult<Url> urlAdd(UrlDto urlDto);
    Result urlDelete(UrlDeleteDto deleteDto);


}
