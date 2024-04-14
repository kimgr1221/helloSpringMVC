package kr.ac.hansung.cse.service;

import kr.ac.hansung.cse.dao.OfferDao;
import kr.ac.hansung.cse.model.Offer;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class OfferService {

    //service -> dao
    @Autowired
    private OfferDao offerDao;

    // 모든 교과목을 가져오는 메서드
    public List<Offer> getAllOffers() {
        return offerDao.getOffers();
    }

    // 새 교과목을 삽입하는 메서드
    public void insert(Offer offer) {
        offerDao.insert(offer);
    }
}
