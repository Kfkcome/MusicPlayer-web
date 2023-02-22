package com.music.service;

import com.music.domain.Mv;

import java.security.NoSuchAlgorithmException;
import java.util.List;

public interface MvService {

    List<Mv> findRandomMv() throws NoSuchAlgorithmException;
}
