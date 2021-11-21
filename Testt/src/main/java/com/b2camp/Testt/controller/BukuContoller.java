package com.b2camp.Testt.controller;

import com.b2camp.Testt.endpoint.BukuEndpoint;
import com.b2camp.Testt.model.request.BukuRequest;
import com.b2camp.Testt.model.response.BukuResponse;
import com.b2camp.Testt.service.impl.BukuServiceImpl;
import com.b2camp.Testt.service.BukuServiceRepo;
import lombok.AllArgsConstructor;
import org.springframework.web.bind.annotation.*;

@RestController
@AllArgsConstructor
@RequestMapping(path = BukuEndpoint.pathbase)
public class BukuContoller {

    private final BukuServiceImpl service;

    @PostMapping
    public BukuResponse createBuku(@RequestBody BukuRequest bukuRequest) {

        return service.createBuku(bukuRequest);
    }

    @GetMapping(path = BukuEndpoint.pathId)
    public BukuResponse GetBukuById(
            @PathVariable(value = BukuEndpoint.variableId) Long id
    ) {
        return service.GetBukuById(id);
    }

    @PutMapping(path = BukuEndpoint.pathId)
    public BukuResponse updateBukuById(
            @PathVariable(BukuEndpoint.variableId)Long id, @RequestBody BukuRequest bukuRequest){
        return service.updateBuku(id, bukuRequest);
    }

    @DeleteMapping(path = BukuEndpoint.pathId)
    public void deletedBukuById(@PathVariable(BukuEndpoint.variableId) Long id) {
        service.deletedBukuById(id);
    }

}
