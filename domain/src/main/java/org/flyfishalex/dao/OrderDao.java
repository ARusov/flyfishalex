package org.flyfishalex.dao;


import org.flyfishalex.model.Order;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.mongodb.core.MongoOperations;
import org.springframework.data.mongodb.core.query.Query;
import org.springframework.stereotype.Repository;

import static org.springframework.data.mongodb.core.query.Criteria.where;
import static org.springframework.data.mongodb.core.query.Query.query;

@Repository
public class OrderDao {

    private static final String SEQ_KEY = "order";
    private static final String SEQ_KEY_POINT = "orderPoint";

    @Autowired
    private MongoOperations operations;

    @Autowired
    private SequenceDAO sequenceDAO;

    public Order getBasketOrder(long userId, int statusCode) {
        Query query = query(where("userId").is(userId).and("status").is(statusCode));
        return operations.findOne(query, Order.class);
    }

    public void saveOrder(Order order) {
        if(order!=null){
            operations.save(order);
        }
    }
}
