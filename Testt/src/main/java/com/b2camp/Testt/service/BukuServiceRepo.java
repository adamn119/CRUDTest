package com.b2camp.Testt.service;

import com.b2camp.Testt.model.request.BukuRequest;
import com.b2camp.Testt.model.response.BukuResponse;

public interface BukuServiceRepo {

    BukuResponse GetBukuById(Long id);

    BukuResponse createBuku(BukuRequest bukuRequest);

    BukuResponse updateBuku(Long id, BukuRequest bukuRequest);

    void deletedBukuById(Long BukuId);
}
