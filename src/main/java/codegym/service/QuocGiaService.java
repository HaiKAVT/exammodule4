package codegym.service;

import codegym.model.QuocGia;
import codegym.repository.IQuocGiaRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
@Service
public class QuocGiaService implements IQuocGiaService{
    @Autowired
    IQuocGiaRepository iQuocGiaRepository;
    @Override
    public QuocGia findById(int id) {
        return iQuocGiaRepository.findById(id).get();
    }

    @Override
    public ArrayList<QuocGia> findAll() {
        return (ArrayList<QuocGia>) iQuocGiaRepository.findAll();
    }
}
