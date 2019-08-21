package net.messi.early.pojo;

import java.util.ArrayList;
import java.util.List;

public class NideshopOrderExpressExample {
    protected String orderByClause;

    protected boolean distinct;

    protected List<Criteria> oredCriteria;

    public NideshopOrderExpressExample() {
        oredCriteria = new ArrayList<Criteria>();
    }

    public void setOrderByClause(String orderByClause) {
        this.orderByClause = orderByClause;
    }

    public String getOrderByClause() {
        return orderByClause;
    }

    public void setDistinct(boolean distinct) {
        this.distinct = distinct;
    }

    public boolean isDistinct() {
        return distinct;
    }

    public List<Criteria> getOredCriteria() {
        return oredCriteria;
    }

    public void or(Criteria criteria) {
        oredCriteria.add(criteria);
    }

    public Criteria or() {
        Criteria criteria = createCriteriaInternal();
        oredCriteria.add(criteria);
        return criteria;
    }

    public Criteria createCriteria() {
        Criteria criteria = createCriteriaInternal();
        if (oredCriteria.size() == 0) {
            oredCriteria.add(criteria);
        }
        return criteria;
    }

    protected Criteria createCriteriaInternal() {
        Criteria criteria = new Criteria();
        return criteria;
    }

    public void clear() {
        oredCriteria.clear();
        orderByClause = null;
        distinct = false;
    }

    protected abstract static class GeneratedCriteria {
        protected List<Criterion> criteria;

        protected GeneratedCriteria() {
            super();
            criteria = new ArrayList<Criterion>();
        }

        public boolean isValid() {
            return criteria.size() > 0;
        }

        public List<Criterion> getAllCriteria() {
            return criteria;
        }

        public List<Criterion> getCriteria() {
            return criteria;
        }

        protected void addCriterion(String condition) {
            if (condition == null) {
                throw new RuntimeException("Value for condition cannot be null");
            }
            criteria.add(new Criterion(condition));
        }

        protected void addCriterion(String condition, Object value, String property) {
            if (value == null) {
                throw new RuntimeException("Value for " + property + " cannot be null");
            }
            criteria.add(new Criterion(condition, value));
        }

        protected void addCriterion(String condition, Object value1, Object value2, String property) {
            if (value1 == null || value2 == null) {
                throw new RuntimeException("Between values for " + property + " cannot be null");
            }
            criteria.add(new Criterion(condition, value1, value2));
        }

        public Criteria andIdIsNull() {
            addCriterion("id is null");
            return (Criteria) this;
        }

        public Criteria andIdIsNotNull() {
            addCriterion("id is not null");
            return (Criteria) this;
        }

        public Criteria andIdEqualTo(Integer value) {
            addCriterion("id =", value, "id");
            return (Criteria) this;
        }

        public Criteria andIdNotEqualTo(Integer value) {
            addCriterion("id <>", value, "id");
            return (Criteria) this;
        }

        public Criteria andIdGreaterThan(Integer value) {
            addCriterion("id >", value, "id");
            return (Criteria) this;
        }

        public Criteria andIdGreaterThanOrEqualTo(Integer value) {
            addCriterion("id >=", value, "id");
            return (Criteria) this;
        }

        public Criteria andIdLessThan(Integer value) {
            addCriterion("id <", value, "id");
            return (Criteria) this;
        }

        public Criteria andIdLessThanOrEqualTo(Integer value) {
            addCriterion("id <=", value, "id");
            return (Criteria) this;
        }

        public Criteria andIdIn(List<Integer> values) {
            addCriterion("id in", values, "id");
            return (Criteria) this;
        }

        public Criteria andIdNotIn(List<Integer> values) {
            addCriterion("id not in", values, "id");
            return (Criteria) this;
        }

        public Criteria andIdBetween(Integer value1, Integer value2) {
            addCriterion("id between", value1, value2, "id");
            return (Criteria) this;
        }

        public Criteria andIdNotBetween(Integer value1, Integer value2) {
            addCriterion("id not between", value1, value2, "id");
            return (Criteria) this;
        }

        public Criteria andOrderIdIsNull() {
            addCriterion("order_id is null");
            return (Criteria) this;
        }

        public Criteria andOrderIdIsNotNull() {
            addCriterion("order_id is not null");
            return (Criteria) this;
        }

        public Criteria andOrderIdEqualTo(Integer value) {
            addCriterion("order_id =", value, "orderId");
            return (Criteria) this;
        }

        public Criteria andOrderIdNotEqualTo(Integer value) {
            addCriterion("order_id <>", value, "orderId");
            return (Criteria) this;
        }

        public Criteria andOrderIdGreaterThan(Integer value) {
            addCriterion("order_id >", value, "orderId");
            return (Criteria) this;
        }

        public Criteria andOrderIdGreaterThanOrEqualTo(Integer value) {
            addCriterion("order_id >=", value, "orderId");
            return (Criteria) this;
        }

        public Criteria andOrderIdLessThan(Integer value) {
            addCriterion("order_id <", value, "orderId");
            return (Criteria) this;
        }

        public Criteria andOrderIdLessThanOrEqualTo(Integer value) {
            addCriterion("order_id <=", value, "orderId");
            return (Criteria) this;
        }

        public Criteria andOrderIdIn(List<Integer> values) {
            addCriterion("order_id in", values, "orderId");
            return (Criteria) this;
        }

        public Criteria andOrderIdNotIn(List<Integer> values) {
            addCriterion("order_id not in", values, "orderId");
            return (Criteria) this;
        }

        public Criteria andOrderIdBetween(Integer value1, Integer value2) {
            addCriterion("order_id between", value1, value2, "orderId");
            return (Criteria) this;
        }

        public Criteria andOrderIdNotBetween(Integer value1, Integer value2) {
            addCriterion("order_id not between", value1, value2, "orderId");
            return (Criteria) this;
        }

        public Criteria andShipperIdIsNull() {
            addCriterion("shipper_id is null");
            return (Criteria) this;
        }

        public Criteria andShipperIdIsNotNull() {
            addCriterion("shipper_id is not null");
            return (Criteria) this;
        }

        public Criteria andShipperIdEqualTo(Integer value) {
            addCriterion("shipper_id =", value, "shipperId");
            return (Criteria) this;
        }

        public Criteria andShipperIdNotEqualTo(Integer value) {
            addCriterion("shipper_id <>", value, "shipperId");
            return (Criteria) this;
        }

        public Criteria andShipperIdGreaterThan(Integer value) {
            addCriterion("shipper_id >", value, "shipperId");
            return (Criteria) this;
        }

        public Criteria andShipperIdGreaterThanOrEqualTo(Integer value) {
            addCriterion("shipper_id >=", value, "shipperId");
            return (Criteria) this;
        }

        public Criteria andShipperIdLessThan(Integer value) {
            addCriterion("shipper_id <", value, "shipperId");
            return (Criteria) this;
        }

        public Criteria andShipperIdLessThanOrEqualTo(Integer value) {
            addCriterion("shipper_id <=", value, "shipperId");
            return (Criteria) this;
        }

        public Criteria andShipperIdIn(List<Integer> values) {
            addCriterion("shipper_id in", values, "shipperId");
            return (Criteria) this;
        }

        public Criteria andShipperIdNotIn(List<Integer> values) {
            addCriterion("shipper_id not in", values, "shipperId");
            return (Criteria) this;
        }

        public Criteria andShipperIdBetween(Integer value1, Integer value2) {
            addCriterion("shipper_id between", value1, value2, "shipperId");
            return (Criteria) this;
        }

        public Criteria andShipperIdNotBetween(Integer value1, Integer value2) {
            addCriterion("shipper_id not between", value1, value2, "shipperId");
            return (Criteria) this;
        }

        public Criteria andShipperNameIsNull() {
            addCriterion("shipper_name is null");
            return (Criteria) this;
        }

        public Criteria andShipperNameIsNotNull() {
            addCriterion("shipper_name is not null");
            return (Criteria) this;
        }

        public Criteria andShipperNameEqualTo(String value) {
            addCriterion("shipper_name =", value, "shipperName");
            return (Criteria) this;
        }

        public Criteria andShipperNameNotEqualTo(String value) {
            addCriterion("shipper_name <>", value, "shipperName");
            return (Criteria) this;
        }

        public Criteria andShipperNameGreaterThan(String value) {
            addCriterion("shipper_name >", value, "shipperName");
            return (Criteria) this;
        }

        public Criteria andShipperNameGreaterThanOrEqualTo(String value) {
            addCriterion("shipper_name >=", value, "shipperName");
            return (Criteria) this;
        }

        public Criteria andShipperNameLessThan(String value) {
            addCriterion("shipper_name <", value, "shipperName");
            return (Criteria) this;
        }

        public Criteria andShipperNameLessThanOrEqualTo(String value) {
            addCriterion("shipper_name <=", value, "shipperName");
            return (Criteria) this;
        }

        public Criteria andShipperNameLike(String value) {
            addCriterion("shipper_name like", value, "shipperName");
            return (Criteria) this;
        }

        public Criteria andShipperNameNotLike(String value) {
            addCriterion("shipper_name not like", value, "shipperName");
            return (Criteria) this;
        }

        public Criteria andShipperNameIn(List<String> values) {
            addCriterion("shipper_name in", values, "shipperName");
            return (Criteria) this;
        }

        public Criteria andShipperNameNotIn(List<String> values) {
            addCriterion("shipper_name not in", values, "shipperName");
            return (Criteria) this;
        }

        public Criteria andShipperNameBetween(String value1, String value2) {
            addCriterion("shipper_name between", value1, value2, "shipperName");
            return (Criteria) this;
        }

        public Criteria andShipperNameNotBetween(String value1, String value2) {
            addCriterion("shipper_name not between", value1, value2, "shipperName");
            return (Criteria) this;
        }

        public Criteria andShipperCodeIsNull() {
            addCriterion("shipper_code is null");
            return (Criteria) this;
        }

        public Criteria andShipperCodeIsNotNull() {
            addCriterion("shipper_code is not null");
            return (Criteria) this;
        }

        public Criteria andShipperCodeEqualTo(String value) {
            addCriterion("shipper_code =", value, "shipperCode");
            return (Criteria) this;
        }

        public Criteria andShipperCodeNotEqualTo(String value) {
            addCriterion("shipper_code <>", value, "shipperCode");
            return (Criteria) this;
        }

        public Criteria andShipperCodeGreaterThan(String value) {
            addCriterion("shipper_code >", value, "shipperCode");
            return (Criteria) this;
        }

        public Criteria andShipperCodeGreaterThanOrEqualTo(String value) {
            addCriterion("shipper_code >=", value, "shipperCode");
            return (Criteria) this;
        }

        public Criteria andShipperCodeLessThan(String value) {
            addCriterion("shipper_code <", value, "shipperCode");
            return (Criteria) this;
        }

        public Criteria andShipperCodeLessThanOrEqualTo(String value) {
            addCriterion("shipper_code <=", value, "shipperCode");
            return (Criteria) this;
        }

        public Criteria andShipperCodeLike(String value) {
            addCriterion("shipper_code like", value, "shipperCode");
            return (Criteria) this;
        }

        public Criteria andShipperCodeNotLike(String value) {
            addCriterion("shipper_code not like", value, "shipperCode");
            return (Criteria) this;
        }

        public Criteria andShipperCodeIn(List<String> values) {
            addCriterion("shipper_code in", values, "shipperCode");
            return (Criteria) this;
        }

        public Criteria andShipperCodeNotIn(List<String> values) {
            addCriterion("shipper_code not in", values, "shipperCode");
            return (Criteria) this;
        }

        public Criteria andShipperCodeBetween(String value1, String value2) {
            addCriterion("shipper_code between", value1, value2, "shipperCode");
            return (Criteria) this;
        }

        public Criteria andShipperCodeNotBetween(String value1, String value2) {
            addCriterion("shipper_code not between", value1, value2, "shipperCode");
            return (Criteria) this;
        }

        public Criteria andLogisticCodeIsNull() {
            addCriterion("logistic_code is null");
            return (Criteria) this;
        }

        public Criteria andLogisticCodeIsNotNull() {
            addCriterion("logistic_code is not null");
            return (Criteria) this;
        }

        public Criteria andLogisticCodeEqualTo(String value) {
            addCriterion("logistic_code =", value, "logisticCode");
            return (Criteria) this;
        }

        public Criteria andLogisticCodeNotEqualTo(String value) {
            addCriterion("logistic_code <>", value, "logisticCode");
            return (Criteria) this;
        }

        public Criteria andLogisticCodeGreaterThan(String value) {
            addCriterion("logistic_code >", value, "logisticCode");
            return (Criteria) this;
        }

        public Criteria andLogisticCodeGreaterThanOrEqualTo(String value) {
            addCriterion("logistic_code >=", value, "logisticCode");
            return (Criteria) this;
        }

        public Criteria andLogisticCodeLessThan(String value) {
            addCriterion("logistic_code <", value, "logisticCode");
            return (Criteria) this;
        }

        public Criteria andLogisticCodeLessThanOrEqualTo(String value) {
            addCriterion("logistic_code <=", value, "logisticCode");
            return (Criteria) this;
        }

        public Criteria andLogisticCodeLike(String value) {
            addCriterion("logistic_code like", value, "logisticCode");
            return (Criteria) this;
        }

        public Criteria andLogisticCodeNotLike(String value) {
            addCriterion("logistic_code not like", value, "logisticCode");
            return (Criteria) this;
        }

        public Criteria andLogisticCodeIn(List<String> values) {
            addCriterion("logistic_code in", values, "logisticCode");
            return (Criteria) this;
        }

        public Criteria andLogisticCodeNotIn(List<String> values) {
            addCriterion("logistic_code not in", values, "logisticCode");
            return (Criteria) this;
        }

        public Criteria andLogisticCodeBetween(String value1, String value2) {
            addCriterion("logistic_code between", value1, value2, "logisticCode");
            return (Criteria) this;
        }

        public Criteria andLogisticCodeNotBetween(String value1, String value2) {
            addCriterion("logistic_code not between", value1, value2, "logisticCode");
            return (Criteria) this;
        }

        public Criteria andTracesIsNull() {
            addCriterion("traces is null");
            return (Criteria) this;
        }

        public Criteria andTracesIsNotNull() {
            addCriterion("traces is not null");
            return (Criteria) this;
        }

        public Criteria andTracesEqualTo(String value) {
            addCriterion("traces =", value, "traces");
            return (Criteria) this;
        }

        public Criteria andTracesNotEqualTo(String value) {
            addCriterion("traces <>", value, "traces");
            return (Criteria) this;
        }

        public Criteria andTracesGreaterThan(String value) {
            addCriterion("traces >", value, "traces");
            return (Criteria) this;
        }

        public Criteria andTracesGreaterThanOrEqualTo(String value) {
            addCriterion("traces >=", value, "traces");
            return (Criteria) this;
        }

        public Criteria andTracesLessThan(String value) {
            addCriterion("traces <", value, "traces");
            return (Criteria) this;
        }

        public Criteria andTracesLessThanOrEqualTo(String value) {
            addCriterion("traces <=", value, "traces");
            return (Criteria) this;
        }

        public Criteria andTracesLike(String value) {
            addCriterion("traces like", value, "traces");
            return (Criteria) this;
        }

        public Criteria andTracesNotLike(String value) {
            addCriterion("traces not like", value, "traces");
            return (Criteria) this;
        }

        public Criteria andTracesIn(List<String> values) {
            addCriterion("traces in", values, "traces");
            return (Criteria) this;
        }

        public Criteria andTracesNotIn(List<String> values) {
            addCriterion("traces not in", values, "traces");
            return (Criteria) this;
        }

        public Criteria andTracesBetween(String value1, String value2) {
            addCriterion("traces between", value1, value2, "traces");
            return (Criteria) this;
        }

        public Criteria andTracesNotBetween(String value1, String value2) {
            addCriterion("traces not between", value1, value2, "traces");
            return (Criteria) this;
        }

        public Criteria andIsFinishIsNull() {
            addCriterion("is_finish is null");
            return (Criteria) this;
        }

        public Criteria andIsFinishIsNotNull() {
            addCriterion("is_finish is not null");
            return (Criteria) this;
        }

        public Criteria andIsFinishEqualTo(Boolean value) {
            addCriterion("is_finish =", value, "isFinish");
            return (Criteria) this;
        }

        public Criteria andIsFinishNotEqualTo(Boolean value) {
            addCriterion("is_finish <>", value, "isFinish");
            return (Criteria) this;
        }

        public Criteria andIsFinishGreaterThan(Boolean value) {
            addCriterion("is_finish >", value, "isFinish");
            return (Criteria) this;
        }

        public Criteria andIsFinishGreaterThanOrEqualTo(Boolean value) {
            addCriterion("is_finish >=", value, "isFinish");
            return (Criteria) this;
        }

        public Criteria andIsFinishLessThan(Boolean value) {
            addCriterion("is_finish <", value, "isFinish");
            return (Criteria) this;
        }

        public Criteria andIsFinishLessThanOrEqualTo(Boolean value) {
            addCriterion("is_finish <=", value, "isFinish");
            return (Criteria) this;
        }

        public Criteria andIsFinishIn(List<Boolean> values) {
            addCriterion("is_finish in", values, "isFinish");
            return (Criteria) this;
        }

        public Criteria andIsFinishNotIn(List<Boolean> values) {
            addCriterion("is_finish not in", values, "isFinish");
            return (Criteria) this;
        }

        public Criteria andIsFinishBetween(Boolean value1, Boolean value2) {
            addCriterion("is_finish between", value1, value2, "isFinish");
            return (Criteria) this;
        }

        public Criteria andIsFinishNotBetween(Boolean value1, Boolean value2) {
            addCriterion("is_finish not between", value1, value2, "isFinish");
            return (Criteria) this;
        }

        public Criteria andRequestCountIsNull() {
            addCriterion("request_count is null");
            return (Criteria) this;
        }

        public Criteria andRequestCountIsNotNull() {
            addCriterion("request_count is not null");
            return (Criteria) this;
        }

        public Criteria andRequestCountEqualTo(Integer value) {
            addCriterion("request_count =", value, "requestCount");
            return (Criteria) this;
        }

        public Criteria andRequestCountNotEqualTo(Integer value) {
            addCriterion("request_count <>", value, "requestCount");
            return (Criteria) this;
        }

        public Criteria andRequestCountGreaterThan(Integer value) {
            addCriterion("request_count >", value, "requestCount");
            return (Criteria) this;
        }

        public Criteria andRequestCountGreaterThanOrEqualTo(Integer value) {
            addCriterion("request_count >=", value, "requestCount");
            return (Criteria) this;
        }

        public Criteria andRequestCountLessThan(Integer value) {
            addCriterion("request_count <", value, "requestCount");
            return (Criteria) this;
        }

        public Criteria andRequestCountLessThanOrEqualTo(Integer value) {
            addCriterion("request_count <=", value, "requestCount");
            return (Criteria) this;
        }

        public Criteria andRequestCountIn(List<Integer> values) {
            addCriterion("request_count in", values, "requestCount");
            return (Criteria) this;
        }

        public Criteria andRequestCountNotIn(List<Integer> values) {
            addCriterion("request_count not in", values, "requestCount");
            return (Criteria) this;
        }

        public Criteria andRequestCountBetween(Integer value1, Integer value2) {
            addCriterion("request_count between", value1, value2, "requestCount");
            return (Criteria) this;
        }

        public Criteria andRequestCountNotBetween(Integer value1, Integer value2) {
            addCriterion("request_count not between", value1, value2, "requestCount");
            return (Criteria) this;
        }

        public Criteria andRequestTimeIsNull() {
            addCriterion("request_time is null");
            return (Criteria) this;
        }

        public Criteria andRequestTimeIsNotNull() {
            addCriterion("request_time is not null");
            return (Criteria) this;
        }

        public Criteria andRequestTimeEqualTo(Integer value) {
            addCriterion("request_time =", value, "requestTime");
            return (Criteria) this;
        }

        public Criteria andRequestTimeNotEqualTo(Integer value) {
            addCriterion("request_time <>", value, "requestTime");
            return (Criteria) this;
        }

        public Criteria andRequestTimeGreaterThan(Integer value) {
            addCriterion("request_time >", value, "requestTime");
            return (Criteria) this;
        }

        public Criteria andRequestTimeGreaterThanOrEqualTo(Integer value) {
            addCriterion("request_time >=", value, "requestTime");
            return (Criteria) this;
        }

        public Criteria andRequestTimeLessThan(Integer value) {
            addCriterion("request_time <", value, "requestTime");
            return (Criteria) this;
        }

        public Criteria andRequestTimeLessThanOrEqualTo(Integer value) {
            addCriterion("request_time <=", value, "requestTime");
            return (Criteria) this;
        }

        public Criteria andRequestTimeIn(List<Integer> values) {
            addCriterion("request_time in", values, "requestTime");
            return (Criteria) this;
        }

        public Criteria andRequestTimeNotIn(List<Integer> values) {
            addCriterion("request_time not in", values, "requestTime");
            return (Criteria) this;
        }

        public Criteria andRequestTimeBetween(Integer value1, Integer value2) {
            addCriterion("request_time between", value1, value2, "requestTime");
            return (Criteria) this;
        }

        public Criteria andRequestTimeNotBetween(Integer value1, Integer value2) {
            addCriterion("request_time not between", value1, value2, "requestTime");
            return (Criteria) this;
        }

        public Criteria andAddTimeIsNull() {
            addCriterion("add_time is null");
            return (Criteria) this;
        }

        public Criteria andAddTimeIsNotNull() {
            addCriterion("add_time is not null");
            return (Criteria) this;
        }

        public Criteria andAddTimeEqualTo(Integer value) {
            addCriterion("add_time =", value, "addTime");
            return (Criteria) this;
        }

        public Criteria andAddTimeNotEqualTo(Integer value) {
            addCriterion("add_time <>", value, "addTime");
            return (Criteria) this;
        }

        public Criteria andAddTimeGreaterThan(Integer value) {
            addCriterion("add_time >", value, "addTime");
            return (Criteria) this;
        }

        public Criteria andAddTimeGreaterThanOrEqualTo(Integer value) {
            addCriterion("add_time >=", value, "addTime");
            return (Criteria) this;
        }

        public Criteria andAddTimeLessThan(Integer value) {
            addCriterion("add_time <", value, "addTime");
            return (Criteria) this;
        }

        public Criteria andAddTimeLessThanOrEqualTo(Integer value) {
            addCriterion("add_time <=", value, "addTime");
            return (Criteria) this;
        }

        public Criteria andAddTimeIn(List<Integer> values) {
            addCriterion("add_time in", values, "addTime");
            return (Criteria) this;
        }

        public Criteria andAddTimeNotIn(List<Integer> values) {
            addCriterion("add_time not in", values, "addTime");
            return (Criteria) this;
        }

        public Criteria andAddTimeBetween(Integer value1, Integer value2) {
            addCriterion("add_time between", value1, value2, "addTime");
            return (Criteria) this;
        }

        public Criteria andAddTimeNotBetween(Integer value1, Integer value2) {
            addCriterion("add_time not between", value1, value2, "addTime");
            return (Criteria) this;
        }

        public Criteria andUpdateTimeIsNull() {
            addCriterion("update_time is null");
            return (Criteria) this;
        }

        public Criteria andUpdateTimeIsNotNull() {
            addCriterion("update_time is not null");
            return (Criteria) this;
        }

        public Criteria andUpdateTimeEqualTo(Integer value) {
            addCriterion("update_time =", value, "updateTime");
            return (Criteria) this;
        }

        public Criteria andUpdateTimeNotEqualTo(Integer value) {
            addCriterion("update_time <>", value, "updateTime");
            return (Criteria) this;
        }

        public Criteria andUpdateTimeGreaterThan(Integer value) {
            addCriterion("update_time >", value, "updateTime");
            return (Criteria) this;
        }

        public Criteria andUpdateTimeGreaterThanOrEqualTo(Integer value) {
            addCriterion("update_time >=", value, "updateTime");
            return (Criteria) this;
        }

        public Criteria andUpdateTimeLessThan(Integer value) {
            addCriterion("update_time <", value, "updateTime");
            return (Criteria) this;
        }

        public Criteria andUpdateTimeLessThanOrEqualTo(Integer value) {
            addCriterion("update_time <=", value, "updateTime");
            return (Criteria) this;
        }

        public Criteria andUpdateTimeIn(List<Integer> values) {
            addCriterion("update_time in", values, "updateTime");
            return (Criteria) this;
        }

        public Criteria andUpdateTimeNotIn(List<Integer> values) {
            addCriterion("update_time not in", values, "updateTime");
            return (Criteria) this;
        }

        public Criteria andUpdateTimeBetween(Integer value1, Integer value2) {
            addCriterion("update_time between", value1, value2, "updateTime");
            return (Criteria) this;
        }

        public Criteria andUpdateTimeNotBetween(Integer value1, Integer value2) {
            addCriterion("update_time not between", value1, value2, "updateTime");
            return (Criteria) this;
        }
    }

    public static class Criteria extends GeneratedCriteria {

        protected Criteria() {
            super();
        }
    }

    public static class Criterion {
        private String condition;

        private Object value;

        private Object secondValue;

        private boolean noValue;

        private boolean singleValue;

        private boolean betweenValue;

        private boolean listValue;

        private String typeHandler;

        public String getCondition() {
            return condition;
        }

        public Object getValue() {
            return value;
        }

        public Object getSecondValue() {
            return secondValue;
        }

        public boolean isNoValue() {
            return noValue;
        }

        public boolean isSingleValue() {
            return singleValue;
        }

        public boolean isBetweenValue() {
            return betweenValue;
        }

        public boolean isListValue() {
            return listValue;
        }

        public String getTypeHandler() {
            return typeHandler;
        }

        protected Criterion(String condition) {
            super();
            this.condition = condition;
            this.typeHandler = null;
            this.noValue = true;
        }

        protected Criterion(String condition, Object value, String typeHandler) {
            super();
            this.condition = condition;
            this.value = value;
            this.typeHandler = typeHandler;
            if (value instanceof List<?>) {
                this.listValue = true;
            } else {
                this.singleValue = true;
            }
        }

        protected Criterion(String condition, Object value) {
            this(condition, value, null);
        }

        protected Criterion(String condition, Object value, Object secondValue, String typeHandler) {
            super();
            this.condition = condition;
            this.value = value;
            this.secondValue = secondValue;
            this.typeHandler = typeHandler;
            this.betweenValue = true;
        }

        protected Criterion(String condition, Object value, Object secondValue) {
            this(condition, value, secondValue, null);
        }
    }
}