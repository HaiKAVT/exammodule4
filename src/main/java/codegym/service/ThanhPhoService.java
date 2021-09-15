package codegym.service;

import codegym.model.ThanhPho;
import codegym.repository.IThanhPhoRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import java.util.ArrayList;

@Service
public class ThanhPhoService implements IThanhPhoService{
    @Autowired
    IThanhPhoRepository iThanhPhoRepository;


    @Override
    public ArrayList<ThanhPho> findAll() {
        return (ArrayList<ThanhPho>) iThanhPhoRepository.findAll();
    }

    @Override
    public ThanhPho findById(int id) {
        return iThanhPhoRepository.findById(id).get();
    }

    @Override
    public ThanhPho save(ThanhPho thanhPho) {
        return iThanhPhoRepository.save(thanhPho);
    }

    @Override
    public void remove(ThanhPho thanhPho) {
        iThanhPhoRepository.delete(thanhPho);
    }

}
