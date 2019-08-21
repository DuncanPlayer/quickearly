package net.messi.early.pojo;

import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.List;

public class NideshopCouponExample {
    protected String orderByClause;

    protected boolean distinct;

    protected List<Criteria> oredCriteria;

    public NideshopCouponExample() {
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

        public Criteria andIdEqualTo(Short value) {
            addCriterion("id =", value, "id");
            return (Criteria) this;
        }

        public Criteria andIdNotEqualTo(Short value) {
            addCriterion("id <>", value, "id");
            return (Criteria) this;
        }

        public Criteria andIdGreaterThan(Short value) {
            addCriterion("id >", value, "id");
            return (Criteria) this;
        }

        public Criteria andIdGreaterThanOrEqualTo(Short value) {
            addCriterion("id >=", value, "id");
            return (Criteria) this;
        }

        public Criteria andIdLessThan(Short value) {
            addCriterion("id <", value, "id");
            return (Criteria) this;
        }

        public Criteria andIdLessThanOrEqualTo(Short value) {
            addCriterion("id <=", value, "id");
            return (Criteria) this;
        }

        public Criteria andIdIn(List<Short> values) {
            addCriterion("id in", values, "id");
            return (Criteria) this;
        }

        public Criteria andIdNotIn(List<Short> values) {
            addCriterion("id not in", values, "id");
            return (Criteria) this;
        }

        public Criteria andIdBetween(Short value1, Short value2) {
            addCriterion("id between", value1, value2, "id");
            return (Criteria) this;
        }

        public Criteria andIdNotBetween(Short value1, Short value2) {
            addCriterion("id not between", value1, value2, "id");
            return (Criteria) this;
        }

        public Criteria andNameIsNull() {
            addCriterion("name is null");
            return (Criteria) this;
        }

        public Criteria andNameIsNotNull() {
            addCriterion("name is not null");
            return (Criteria) this;
        }

        public Criteria andNameEqualTo(String value) {
            addCriterion("name =", value, "name");
            return (Criteria) this;
        }

        public Criteria andNameNotEqualTo(String value) {
            addCriterion("name <>", value, "name");
            return (Criteria) this;
        }

        public Criteria andNameGreaterThan(String value) {
            addCriterion("name >", value, "name");
            return (Criteria) this;
        }

        public Criteria andNameGreaterThanOrEqualTo(String value) {
            addCriterion("name >=", value, "name");
            return (Criteria) this;
        }

        public Criteria andNameLessThan(String value) {
            addCriterion("name <", value, "name");
            return (Criteria) this;
        }

        public Criteria andNameLessThanOrEqualTo(String value) {
            addCriterion("name <=", value, "name");
            return (Criteria) this;
        }

        public Criteria andNameLike(String value) {
            addCriterion("name like", value, "name");
            return (Criteria) this;
        }

        public Criteria andNameNotLike(String value) {
            addCriterion("name not like", value, "name");
            return (Criteria) this;
        }

        public Criteria andNameIn(List<String> values) {
            addCriterion("name in", values, "name");
            return (Criteria) this;
        }

        public Criteria andNameNotIn(List<String> values) {
            addCriterion("name not in", values, "name");
            return (Criteria) this;
        }

        public Criteria andNameBetween(String value1, String value2) {
            addCriterion("name between", value1, value2, "name");
            return (Criteria) this;
        }

        public Criteria andNameNotBetween(String value1, String value2) {
            addCriterion("name not between", value1, value2, "name");
            return (Criteria) this;
        }

        public Criteria andTypeMoneyIsNull() {
            addCriterion("type_money is null");
            return (Criteria) this;
        }

        public Criteria andTypeMoneyIsNotNull() {
            addCriterion("type_money is not null");
            return (Criteria) this;
        }

        public Criteria andTypeMoneyEqualTo(BigDecimal value) {
            addCriterion("type_money =", value, "typeMoney");
            return (Criteria) this;
        }

        public Criteria andTypeMoneyNotEqualTo(BigDecimal value) {
            addCriterion("type_money <>", value, "typeMoney");
            return (Criteria) this;
        }

        public Criteria andTypeMoneyGreaterThan(BigDecimal value) {
            addCriterion("type_money >", value, "typeMoney");
            return (Criteria) this;
        }

        public Criteria andTypeMoneyGreaterThanOrEqualTo(BigDecimal value) {
            addCriterion("type_money >=", value, "typeMoney");
            return (Criteria) this;
        }

        public Criteria andTypeMoneyLessThan(BigDecimal value) {
            addCriterion("type_money <", value, "typeMoney");
            return (Criteria) this;
        }

        public Criteria andTypeMoneyLessThanOrEqualTo(BigDecimal value) {
            addCriterion("type_money <=", value, "typeMoney");
            return (Criteria) this;
        }

        public Criteria andTypeMoneyIn(List<BigDecimal> values) {
            addCriterion("type_money in", values, "typeMoney");
            return (Criteria) this;
        }

        public Criteria andTypeMoneyNotIn(List<BigDecimal> values) {
            addCriterion("type_money not in", values, "typeMoney");
            return (Criteria) this;
        }

        public Criteria andTypeMoneyBetween(BigDecimal value1, BigDecimal value2) {
            addCriterion("type_money between", value1, value2, "typeMoney");
            return (Criteria) this;
        }

        public Criteria andTypeMoneyNotBetween(BigDecimal value1, BigDecimal value2) {
            addCriterion("type_money not between", value1, value2, "typeMoney");
            return (Criteria) this;
        }

        public Criteria andSendTypeIsNull() {
            addCriterion("send_type is null");
            return (Criteria) this;
        }

        public Criteria andSendTypeIsNotNull() {
            addCriterion("send_type is not null");
            return (Criteria) this;
        }

        public Criteria andSendTypeEqualTo(Byte value) {
            addCriterion("send_type =", value, "sendType");
            return (Criteria) this;
        }

        public Criteria andSendTypeNotEqualTo(Byte value) {
            addCriterion("send_type <>", value, "sendType");
            return (Criteria) this;
        }

        public Criteria andSendTypeGreaterThan(Byte value) {
            addCriterion("send_type >", value, "sendType");
            return (Criteria) this;
        }

        public Criteria andSendTypeGreaterThanOrEqualTo(Byte value) {
            addCriterion("send_type >=", value, "sendType");
            return (Criteria) this;
        }

        public Criteria andSendTypeLessThan(Byte value) {
            addCriterion("send_type <", value, "sendType");
            return (Criteria) this;
        }

        public Criteria andSendTypeLessThanOrEqualTo(Byte value) {
            addCriterion("send_type <=", value, "sendType");
            return (Criteria) this;
        }

        public Criteria andSendTypeIn(List<Byte> values) {
            addCriterion("send_type in", values, "sendType");
            return (Criteria) this;
        }

        public Criteria andSendTypeNotIn(List<Byte> values) {
            addCriterion("send_type not in", values, "sendType");
            return (Criteria) this;
        }

        public Criteria andSendTypeBetween(Byte value1, Byte value2) {
            addCriterion("send_type between", value1, value2, "sendType");
            return (Criteria) this;
        }

        public Criteria andSendTypeNotBetween(Byte value1, Byte value2) {
            addCriterion("send_type not between", value1, value2, "sendType");
            return (Criteria) this;
        }

        public Criteria andMinAmountIsNull() {
            addCriterion("min_amount is null");
            return (Criteria) this;
        }

        public Criteria andMinAmountIsNotNull() {
            addCriterion("min_amount is not null");
            return (Criteria) this;
        }

        public Criteria andMinAmountEqualTo(BigDecimal value) {
            addCriterion("min_amount =", value, "minAmount");
            return (Criteria) this;
        }

        public Criteria andMinAmountNotEqualTo(BigDecimal value) {
            addCriterion("min_amount <>", value, "minAmount");
            return (Criteria) this;
        }

        public Criteria andMinAmountGreaterThan(BigDecimal value) {
            addCriterion("min_amount >", value, "minAmount");
            return (Criteria) this;
        }

        public Criteria andMinAmountGreaterThanOrEqualTo(BigDecimal value) {
            addCriterion("min_amount >=", value, "minAmount");
            return (Criteria) this;
        }

        public Criteria andMinAmountLessThan(BigDecimal value) {
            addCriterion("min_amount <", value, "minAmount");
            return (Criteria) this;
        }

        public Criteria andMinAmountLessThanOrEqualTo(BigDecimal value) {
            addCriterion("min_amount <=", value, "minAmount");
            return (Criteria) this;
        }

        public Criteria andMinAmountIn(List<BigDecimal> values) {
            addCriterion("min_amount in", values, "minAmount");
            return (Criteria) this;
        }

        public Criteria andMinAmountNotIn(List<BigDecimal> values) {
            addCriterion("min_amount not in", values, "minAmount");
            return (Criteria) this;
        }

        public Criteria andMinAmountBetween(BigDecimal value1, BigDecimal value2) {
            addCriterion("min_amount between", value1, value2, "minAmount");
            return (Criteria) this;
        }

        public Criteria andMinAmountNotBetween(BigDecimal value1, BigDecimal value2) {
            addCriterion("min_amount not between", value1, value2, "minAmount");
            return (Criteria) this;
        }

        public Criteria andMaxAmountIsNull() {
            addCriterion("max_amount is null");
            return (Criteria) this;
        }

        public Criteria andMaxAmountIsNotNull() {
            addCriterion("max_amount is not null");
            return (Criteria) this;
        }

        public Criteria andMaxAmountEqualTo(BigDecimal value) {
            addCriterion("max_amount =", value, "maxAmount");
            return (Criteria) this;
        }

        public Criteria andMaxAmountNotEqualTo(BigDecimal value) {
            addCriterion("max_amount <>", value, "maxAmount");
            return (Criteria) this;
        }

        public Criteria andMaxAmountGreaterThan(BigDecimal value) {
            addCriterion("max_amount >", value, "maxAmount");
            return (Criteria) this;
        }

        public Criteria andMaxAmountGreaterThanOrEqualTo(BigDecimal value) {
            addCriterion("max_amount >=", value, "maxAmount");
            return (Criteria) this;
        }

        public Criteria andMaxAmountLessThan(BigDecimal value) {
            addCriterion("max_amount <", value, "maxAmount");
            return (Criteria) this;
        }

        public Criteria andMaxAmountLessThanOrEqualTo(BigDecimal value) {
            addCriterion("max_amount <=", value, "maxAmount");
            return (Criteria) this;
        }

        public Criteria andMaxAmountIn(List<BigDecimal> values) {
            addCriterion("max_amount in", values, "maxAmount");
            return (Criteria) this;
        }

        public Criteria andMaxAmountNotIn(List<BigDecimal> values) {
            addCriterion("max_amount not in", values, "maxAmount");
            return (Criteria) this;
        }

        public Criteria andMaxAmountBetween(BigDecimal value1, BigDecimal value2) {
            addCriterion("max_amount between", value1, value2, "maxAmount");
            return (Criteria) this;
        }

        public Criteria andMaxAmountNotBetween(BigDecimal value1, BigDecimal value2) {
            addCriterion("max_amount not between", value1, value2, "maxAmount");
            return (Criteria) this;
        }

        public Criteria andSendStartDateIsNull() {
            addCriterion("send_start_date is null");
            return (Criteria) this;
        }

        public Criteria andSendStartDateIsNotNull() {
            addCriterion("send_start_date is not null");
            return (Criteria) this;
        }

        public Criteria andSendStartDateEqualTo(String value) {
            addCriterion("send_start_date =", value, "sendStartDate");
            return (Criteria) this;
        }

        public Criteria andSendStartDateNotEqualTo(String value) {
            addCriterion("send_start_date <>", value, "sendStartDate");
            return (Criteria) this;
        }

        public Criteria andSendStartDateGreaterThan(String value) {
            addCriterion("send_start_date >", value, "sendStartDate");
            return (Criteria) this;
        }

        public Criteria andSendStartDateGreaterThanOrEqualTo(String value) {
            addCriterion("send_start_date >=", value, "sendStartDate");
            return (Criteria) this;
        }

        public Criteria andSendStartDateLessThan(String value) {
            addCriterion("send_start_date <", value, "sendStartDate");
            return (Criteria) this;
        }

        public Criteria andSendStartDateLessThanOrEqualTo(String value) {
            addCriterion("send_start_date <=", value, "sendStartDate");
            return (Criteria) this;
        }

        public Criteria andSendStartDateLike(String value) {
            addCriterion("send_start_date like", value, "sendStartDate");
            return (Criteria) this;
        }

        public Criteria andSendStartDateNotLike(String value) {
            addCriterion("send_start_date not like", value, "sendStartDate");
            return (Criteria) this;
        }

        public Criteria andSendStartDateIn(List<String> values) {
            addCriterion("send_start_date in", values, "sendStartDate");
            return (Criteria) this;
        }

        public Criteria andSendStartDateNotIn(List<String> values) {
            addCriterion("send_start_date not in", values, "sendStartDate");
            return (Criteria) this;
        }

        public Criteria andSendStartDateBetween(String value1, String value2) {
            addCriterion("send_start_date between", value1, value2, "sendStartDate");
            return (Criteria) this;
        }

        public Criteria andSendStartDateNotBetween(String value1, String value2) {
            addCriterion("send_start_date not between", value1, value2, "sendStartDate");
            return (Criteria) this;
        }

        public Criteria andSendEndDateIsNull() {
            addCriterion("send_end_date is null");
            return (Criteria) this;
        }

        public Criteria andSendEndDateIsNotNull() {
            addCriterion("send_end_date is not null");
            return (Criteria) this;
        }

        public Criteria andSendEndDateEqualTo(String value) {
            addCriterion("send_end_date =", value, "sendEndDate");
            return (Criteria) this;
        }

        public Criteria andSendEndDateNotEqualTo(String value) {
            addCriterion("send_end_date <>", value, "sendEndDate");
            return (Criteria) this;
        }

        public Criteria andSendEndDateGreaterThan(String value) {
            addCriterion("send_end_date >", value, "sendEndDate");
            return (Criteria) this;
        }

        public Criteria andSendEndDateGreaterThanOrEqualTo(String value) {
            addCriterion("send_end_date >=", value, "sendEndDate");
            return (Criteria) this;
        }

        public Criteria andSendEndDateLessThan(String value) {
            addCriterion("send_end_date <", value, "sendEndDate");
            return (Criteria) this;
        }

        public Criteria andSendEndDateLessThanOrEqualTo(String value) {
            addCriterion("send_end_date <=", value, "sendEndDate");
            return (Criteria) this;
        }

        public Criteria andSendEndDateLike(String value) {
            addCriterion("send_end_date like", value, "sendEndDate");
            return (Criteria) this;
        }

        public Criteria andSendEndDateNotLike(String value) {
            addCriterion("send_end_date not like", value, "sendEndDate");
            return (Criteria) this;
        }

        public Criteria andSendEndDateIn(List<String> values) {
            addCriterion("send_end_date in", values, "sendEndDate");
            return (Criteria) this;
        }

        public Criteria andSendEndDateNotIn(List<String> values) {
            addCriterion("send_end_date not in", values, "sendEndDate");
            return (Criteria) this;
        }

        public Criteria andSendEndDateBetween(String value1, String value2) {
            addCriterion("send_end_date between", value1, value2, "sendEndDate");
            return (Criteria) this;
        }

        public Criteria andSendEndDateNotBetween(String value1, String value2) {
            addCriterion("send_end_date not between", value1, value2, "sendEndDate");
            return (Criteria) this;
        }

        public Criteria andUseStartDateIsNull() {
            addCriterion("use_start_date is null");
            return (Criteria) this;
        }

        public Criteria andUseStartDateIsNotNull() {
            addCriterion("use_start_date is not null");
            return (Criteria) this;
        }

        public Criteria andUseStartDateEqualTo(String value) {
            addCriterion("use_start_date =", value, "useStartDate");
            return (Criteria) this;
        }

        public Criteria andUseStartDateNotEqualTo(String value) {
            addCriterion("use_start_date <>", value, "useStartDate");
            return (Criteria) this;
        }

        public Criteria andUseStartDateGreaterThan(String value) {
            addCriterion("use_start_date >", value, "useStartDate");
            return (Criteria) this;
        }

        public Criteria andUseStartDateGreaterThanOrEqualTo(String value) {
            addCriterion("use_start_date >=", value, "useStartDate");
            return (Criteria) this;
        }

        public Criteria andUseStartDateLessThan(String value) {
            addCriterion("use_start_date <", value, "useStartDate");
            return (Criteria) this;
        }

        public Criteria andUseStartDateLessThanOrEqualTo(String value) {
            addCriterion("use_start_date <=", value, "useStartDate");
            return (Criteria) this;
        }

        public Criteria andUseStartDateLike(String value) {
            addCriterion("use_start_date like", value, "useStartDate");
            return (Criteria) this;
        }

        public Criteria andUseStartDateNotLike(String value) {
            addCriterion("use_start_date not like", value, "useStartDate");
            return (Criteria) this;
        }

        public Criteria andUseStartDateIn(List<String> values) {
            addCriterion("use_start_date in", values, "useStartDate");
            return (Criteria) this;
        }

        public Criteria andUseStartDateNotIn(List<String> values) {
            addCriterion("use_start_date not in", values, "useStartDate");
            return (Criteria) this;
        }

        public Criteria andUseStartDateBetween(String value1, String value2) {
            addCriterion("use_start_date between", value1, value2, "useStartDate");
            return (Criteria) this;
        }

        public Criteria andUseStartDateNotBetween(String value1, String value2) {
            addCriterion("use_start_date not between", value1, value2, "useStartDate");
            return (Criteria) this;
        }

        public Criteria andUseEndDateIsNull() {
            addCriterion("use_end_date is null");
            return (Criteria) this;
        }

        public Criteria andUseEndDateIsNotNull() {
            addCriterion("use_end_date is not null");
            return (Criteria) this;
        }

        public Criteria andUseEndDateEqualTo(String value) {
            addCriterion("use_end_date =", value, "useEndDate");
            return (Criteria) this;
        }

        public Criteria andUseEndDateNotEqualTo(String value) {
            addCriterion("use_end_date <>", value, "useEndDate");
            return (Criteria) this;
        }

        public Criteria andUseEndDateGreaterThan(String value) {
            addCriterion("use_end_date >", value, "useEndDate");
            return (Criteria) this;
        }

        public Criteria andUseEndDateGreaterThanOrEqualTo(String value) {
            addCriterion("use_end_date >=", value, "useEndDate");
            return (Criteria) this;
        }

        public Criteria andUseEndDateLessThan(String value) {
            addCriterion("use_end_date <", value, "useEndDate");
            return (Criteria) this;
        }

        public Criteria andUseEndDateLessThanOrEqualTo(String value) {
            addCriterion("use_end_date <=", value, "useEndDate");
            return (Criteria) this;
        }

        public Criteria andUseEndDateLike(String value) {
            addCriterion("use_end_date like", value, "useEndDate");
            return (Criteria) this;
        }

        public Criteria andUseEndDateNotLike(String value) {
            addCriterion("use_end_date not like", value, "useEndDate");
            return (Criteria) this;
        }

        public Criteria andUseEndDateIn(List<String> values) {
            addCriterion("use_end_date in", values, "useEndDate");
            return (Criteria) this;
        }

        public Criteria andUseEndDateNotIn(List<String> values) {
            addCriterion("use_end_date not in", values, "useEndDate");
            return (Criteria) this;
        }

        public Criteria andUseEndDateBetween(String value1, String value2) {
            addCriterion("use_end_date between", value1, value2, "useEndDate");
            return (Criteria) this;
        }

        public Criteria andUseEndDateNotBetween(String value1, String value2) {
            addCriterion("use_end_date not between", value1, value2, "useEndDate");
            return (Criteria) this;
        }

        public Criteria andMinGoodsAmountIsNull() {
            addCriterion("min_goods_amount is null");
            return (Criteria) this;
        }

        public Criteria andMinGoodsAmountIsNotNull() {
            addCriterion("min_goods_amount is not null");
            return (Criteria) this;
        }

        public Criteria andMinGoodsAmountEqualTo(BigDecimal value) {
            addCriterion("min_goods_amount =", value, "minGoodsAmount");
            return (Criteria) this;
        }

        public Criteria andMinGoodsAmountNotEqualTo(BigDecimal value) {
            addCriterion("min_goods_amount <>", value, "minGoodsAmount");
            return (Criteria) this;
        }

        public Criteria andMinGoodsAmountGreaterThan(BigDecimal value) {
            addCriterion("min_goods_amount >", value, "minGoodsAmount");
            return (Criteria) this;
        }

        public Criteria andMinGoodsAmountGreaterThanOrEqualTo(BigDecimal value) {
            addCriterion("min_goods_amount >=", value, "minGoodsAmount");
            return (Criteria) this;
        }

        public Criteria andMinGoodsAmountLessThan(BigDecimal value) {
            addCriterion("min_goods_amount <", value, "minGoodsAmount");
            return (Criteria) this;
        }

        public Criteria andMinGoodsAmountLessThanOrEqualTo(BigDecimal value) {
            addCriterion("min_goods_amount <=", value, "minGoodsAmount");
            return (Criteria) this;
        }

        public Criteria andMinGoodsAmountIn(List<BigDecimal> values) {
            addCriterion("min_goods_amount in", values, "minGoodsAmount");
            return (Criteria) this;
        }

        public Criteria andMinGoodsAmountNotIn(List<BigDecimal> values) {
            addCriterion("min_goods_amount not in", values, "minGoodsAmount");
            return (Criteria) this;
        }

        public Criteria andMinGoodsAmountBetween(BigDecimal value1, BigDecimal value2) {
            addCriterion("min_goods_amount between", value1, value2, "minGoodsAmount");
            return (Criteria) this;
        }

        public Criteria andMinGoodsAmountNotBetween(BigDecimal value1, BigDecimal value2) {
            addCriterion("min_goods_amount not between", value1, value2, "minGoodsAmount");
            return (Criteria) this;
        }

        public Criteria andTitleIsNull() {
            addCriterion("title is null");
            return (Criteria) this;
        }

        public Criteria andTitleIsNotNull() {
            addCriterion("title is not null");
            return (Criteria) this;
        }

        public Criteria andTitleEqualTo(String value) {
            addCriterion("title =", value, "title");
            return (Criteria) this;
        }

        public Criteria andTitleNotEqualTo(String value) {
            addCriterion("title <>", value, "title");
            return (Criteria) this;
        }

        public Criteria andTitleGreaterThan(String value) {
            addCriterion("title >", value, "title");
            return (Criteria) this;
        }

        public Criteria andTitleGreaterThanOrEqualTo(String value) {
            addCriterion("title >=", value, "title");
            return (Criteria) this;
        }

        public Criteria andTitleLessThan(String value) {
            addCriterion("title <", value, "title");
            return (Criteria) this;
        }

        public Criteria andTitleLessThanOrEqualTo(String value) {
            addCriterion("title <=", value, "title");
            return (Criteria) this;
        }

        public Criteria andTitleLike(String value) {
            addCriterion("title like", value, "title");
            return (Criteria) this;
        }

        public Criteria andTitleNotLike(String value) {
            addCriterion("title not like", value, "title");
            return (Criteria) this;
        }

        public Criteria andTitleIn(List<String> values) {
            addCriterion("title in", values, "title");
            return (Criteria) this;
        }

        public Criteria andTitleNotIn(List<String> values) {
            addCriterion("title not in", values, "title");
            return (Criteria) this;
        }

        public Criteria andTitleBetween(String value1, String value2) {
            addCriterion("title between", value1, value2, "title");
            return (Criteria) this;
        }

        public Criteria andTitleNotBetween(String value1, String value2) {
            addCriterion("title not between", value1, value2, "title");
            return (Criteria) this;
        }

        public Criteria andTitlenameIsNull() {
            addCriterion("titleName is null");
            return (Criteria) this;
        }

        public Criteria andTitlenameIsNotNull() {
            addCriterion("titleName is not null");
            return (Criteria) this;
        }

        public Criteria andTitlenameEqualTo(String value) {
            addCriterion("titleName =", value, "titlename");
            return (Criteria) this;
        }

        public Criteria andTitlenameNotEqualTo(String value) {
            addCriterion("titleName <>", value, "titlename");
            return (Criteria) this;
        }

        public Criteria andTitlenameGreaterThan(String value) {
            addCriterion("titleName >", value, "titlename");
            return (Criteria) this;
        }

        public Criteria andTitlenameGreaterThanOrEqualTo(String value) {
            addCriterion("titleName >=", value, "titlename");
            return (Criteria) this;
        }

        public Criteria andTitlenameLessThan(String value) {
            addCriterion("titleName <", value, "titlename");
            return (Criteria) this;
        }

        public Criteria andTitlenameLessThanOrEqualTo(String value) {
            addCriterion("titleName <=", value, "titlename");
            return (Criteria) this;
        }

        public Criteria andTitlenameLike(String value) {
            addCriterion("titleName like", value, "titlename");
            return (Criteria) this;
        }

        public Criteria andTitlenameNotLike(String value) {
            addCriterion("titleName not like", value, "titlename");
            return (Criteria) this;
        }

        public Criteria andTitlenameIn(List<String> values) {
            addCriterion("titleName in", values, "titlename");
            return (Criteria) this;
        }

        public Criteria andTitlenameNotIn(List<String> values) {
            addCriterion("titleName not in", values, "titlename");
            return (Criteria) this;
        }

        public Criteria andTitlenameBetween(String value1, String value2) {
            addCriterion("titleName between", value1, value2, "titlename");
            return (Criteria) this;
        }

        public Criteria andTitlenameNotBetween(String value1, String value2) {
            addCriterion("titleName not between", value1, value2, "titlename");
            return (Criteria) this;
        }

        public Criteria andNeedtextIsNull() {
            addCriterion("needText is null");
            return (Criteria) this;
        }

        public Criteria andNeedtextIsNotNull() {
            addCriterion("needText is not null");
            return (Criteria) this;
        }

        public Criteria andNeedtextEqualTo(String value) {
            addCriterion("needText =", value, "needtext");
            return (Criteria) this;
        }

        public Criteria andNeedtextNotEqualTo(String value) {
            addCriterion("needText <>", value, "needtext");
            return (Criteria) this;
        }

        public Criteria andNeedtextGreaterThan(String value) {
            addCriterion("needText >", value, "needtext");
            return (Criteria) this;
        }

        public Criteria andNeedtextGreaterThanOrEqualTo(String value) {
            addCriterion("needText >=", value, "needtext");
            return (Criteria) this;
        }

        public Criteria andNeedtextLessThan(String value) {
            addCriterion("needText <", value, "needtext");
            return (Criteria) this;
        }

        public Criteria andNeedtextLessThanOrEqualTo(String value) {
            addCriterion("needText <=", value, "needtext");
            return (Criteria) this;
        }

        public Criteria andNeedtextLike(String value) {
            addCriterion("needText like", value, "needtext");
            return (Criteria) this;
        }

        public Criteria andNeedtextNotLike(String value) {
            addCriterion("needText not like", value, "needtext");
            return (Criteria) this;
        }

        public Criteria andNeedtextIn(List<String> values) {
            addCriterion("needText in", values, "needtext");
            return (Criteria) this;
        }

        public Criteria andNeedtextNotIn(List<String> values) {
            addCriterion("needText not in", values, "needtext");
            return (Criteria) this;
        }

        public Criteria andNeedtextBetween(String value1, String value2) {
            addCriterion("needText between", value1, value2, "needtext");
            return (Criteria) this;
        }

        public Criteria andNeedtextNotBetween(String value1, String value2) {
            addCriterion("needText not between", value1, value2, "needtext");
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