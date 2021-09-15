package codegym.service;

import codegym.model.QuocGia;

import java.util.ArrayList;

public interface IQuocGiaService {
    public QuocGia findById(int id);

    public ArrayList<QuocGia> findAll();
}
