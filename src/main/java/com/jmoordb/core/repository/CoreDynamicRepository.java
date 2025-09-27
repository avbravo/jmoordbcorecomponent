/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Interface.java to edit this template
 */
package com.jmoordb.core.repository;

import com.jmoordb.core.model.JmoordbException;
import com.jmoordb.core.model.Search;
import com.jmoordb.core.model.Sorted;
import com.jmoordb.core.annotation.repository.CoreException;
import com.jmoordb.core.annotation.repository.DeleteBy;
import com.jmoordb.core.annotation.repository.DeleteMany;
import com.jmoordb.core.annotation.repository.Find;
import com.jmoordb.core.annotation.repository.Lookup;
import com.jmoordb.core.annotation.repository.Save;
import com.jmoordb.core.annotation.repository.Update;
import com.jmoordb.core.annotation.repository.UpdateMany;
import com.jmoordb.core.model.DynamicInfo;
import com.jmoordb.core.model.Pagination;
import com.mongodb.client.ListIndexesIterable;
import com.mongodb.client.MongoCollection;
import com.mongodb.client.MongoIterable;
import java.util.List;
import java.util.Optional;
import org.bson.Document;
import org.bson.conversions.Bson;

/**
 *
 * @author avbravo
 */
public interface CoreDynamicRepository<T, PK> {

    

    @Save
    public Optional<T> save(T t,DynamicInfo dynamicInfo );

    @Update
    public Boolean update(T t,DynamicInfo dynamicInfo );

    @Find()
    public List<T> findAll(DynamicInfo dynamicInfo );

    @Find()
    public List<T> findAllPagination(Pagination pagination,DynamicInfo dynamicInfo );

    @Find()
    public List<T> findAllSorted(Sorted sorted,DynamicInfo dynamicInfo );

    @Find()
    public List<T> findAllPaginationSorted(Pagination pagination, Sorted sorted, DynamicInfo dynamicInfo );

    public Optional<T> findByPk(PK id,DynamicInfo dynamicInfo );

    @DeleteBy
    public Long deleteByPk(PK id,DynamicInfo dynamicInfo );

    @DeleteMany
    public Long deleteMany(Search search, DynamicInfo dynamicInfo );

    @UpdateMany
    public Long updateMany(Bson query, Bson update,DynamicInfo dynamicInfo);

    @Lookup
    public List<T> lookup(Search search,DynamicInfo dynamicInfo);

    @CoreException()
    public JmoordbException getJmoordbException();

    public String createIndex(Bson bson,DynamicInfo dynamicInfo);

    public void dropIndex(Bson bson,DynamicInfo dynamicInfo);

    public Optional<ListIndexesIterable<Document>> listIndexes(DynamicInfo dynamicInfo);

    public Optional<MongoIterable<String>> listCollectionNames(DynamicInfo dynamicInfo);

    public Optional<MongoCollection<Document>> getCollection(DynamicInfo dynamicInfo);

}
