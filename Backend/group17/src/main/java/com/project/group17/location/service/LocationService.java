package com.project.group17.location.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.project.group17.location.entity.LocationEntity;
import com.project.group17.location.repository.LocationRepository;

@Service
public class LocationService {
    
    @Autowired
    private LocationRepository locationRepository;

    public void addDefaultLocations(){
//        locationRepository.save(new LocationEntity("Halifax South End", "44.635132918937806", "-63.57985798361541"));
//        locationRepository.save(new LocationEntity("Halifax West End", "44.65192658618188", "-63.61298862922718"));
//        locationRepository.save(new LocationEntity("Halifax North End", "44.65955846444604", "-63.60183063993835"));
//        locationRepository.save(new LocationEntity("Halifax East End", "44.64768282753042", "-63.57290569703296"));
//        locationRepository.save(new LocationEntity("Downtown Halifax", "44.64768282753042", "-63.57290569703296"));
//        locationRepository.save(new LocationEntity("Fairview", "44.65461312174794", "-63.63839451135653"));
//        locationRepository.save(new LocationEntity("Bedford", "44.72265083988094", "-63.69079414564534"));
//        locationRepository.save(new LocationEntity("Timberlea", "44.66175625881382", "-63.75207725181231"));
//        locationRepository.save(new LocationEntity("Sackville", "44.768394409225046", "-63.69103839346116"));
//        locationRepository.save(new LocationEntity("Hammonds Plains", "44.73669884252296", "-63.79540849239174"));
//        locationRepository.save(new LocationEntity("Lakeside", "44.636653411230085", "-63.69982531272396"));
//        locationRepository.save(new LocationEntity("Armdale", "44.6301063409465", "-63.608053784657024"));
//        locationRepository.save(new LocationEntity("Clayton Park", "44.660464449196354", "-63.64642900811929"));
//        locationRepository.save(new LocationEntity("Dartmouth", "44.665958693547246", "-63.568494743677874"));
//        locationRepository.save(new LocationEntity("Cole Harbour", "44.6729459579599", "-63.47782982298076"));
    }

    public LocationEntity getLocationEntity(String city){
        return locationRepository.findByCity(city);
    }
}
