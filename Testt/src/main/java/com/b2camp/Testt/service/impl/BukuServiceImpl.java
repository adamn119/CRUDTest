package com.b2camp.Testt.service.impl;

import com.b2camp.Testt.model.entity.Buku;
import com.b2camp.Testt.model.request.BukuRequest;
import com.b2camp.Testt.model.response.BukuResponse;
import com.b2camp.Testt.repository.BukuRepository;
import com.b2camp.Testt.service.BukuServiceRepo;
import com.sun.xml.bind.v2.schemagen.episode.SchemaBindings;
import lombok.AllArgsConstructor;
import org.modelmapper.ModelMapper;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.PathVariable;

import javax.transaction.Transactional;
import java.util.List;
import java.util.stream.Collectors;

@Service
@AllArgsConstructor
public class BukuServiceImpl implements BukuServiceRepo {

    private final BukuRepository repository;
    private final ModelMapper modelMapper;

    @Override
    @Transactional
    public BukuResponse createBuku(BukuRequest bukuRequest) {
        var bukuEntity = modelMapper.map(bukuRequest, Buku.class);
        return modelMapper.map(repository.save(bukuEntity),BukuResponse.class);
    }

    @Override
    public BukuResponse GetBukuById(Long id){
        return repository.findById(id).map(buku -> modelMapper.map(buku, BukuResponse.class))
                .orElseThrow();
    }


    @Override
    @Transactional
    public BukuResponse updateBuku(Long bukuId, BukuRequest bukuRequest){
        var bukuIfExist = repository.existsById(bukuId);
        var bukuEntity = repository.findById(bukuId).orElseThrow();

        bukuEntity.setName(bukuRequest.getName());
        bukuEntity.setTahunTerbit(bukuRequest.getTahunTerbit());
        bukuEntity.setPengarang(bukuRequest.getPengarang());


        return modelMapper.map(repository.save(bukuEntity), BukuResponse.class);

    }

    @Override
    @Transactional
    public void deletedBukuById(Long bukuId) {
        var bukuIsExist = repository.existsById(bukuId);

        if (!bukuIsExist) {
            throw new RuntimeException();
        }
        repository.deleteById(bukuId);
    }

}
