package com.example.demo.DataAccess.abstracts.concretes;

import com.example.demo.Entities.concretes.Url;
import com.example.demo.Entities.dtos.UrlListDto;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.util.List;

public interface UrlDao extends JpaRepository<Url,Long> {

    @Query("Select new com.example.demo.Entities.dtos.UrlListDto(u.id,u.Url,u.shortUrl) From Url u where u.user.id=:userId")
    List<UrlListDto> getUrlFindByUserId(Long userId);

    Url getByShortUrl(String shortUrl);

}
