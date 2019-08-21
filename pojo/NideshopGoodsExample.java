package net.messi.early.pojo;

import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.List;

public class NideshopGoodsExample {
    protected String orderByClause;

    protected boolean distinct;

    protected List<Criteria> oredCriteria;

    public NideshopGoodsExample() {
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

        public Criteria andCategoryIdIsNull() {
            addCriterion("category_id is null");
            return (Criteria) this;
        }

        public Criteria andCategoryIdIsNotNull() {
            addCriterion("category_id is not null");
            return (Criteria) this;
        }

        public Criteria andCategoryIdEqualTo(Integer value) {
            addCriterion("category_id =", value, "categoryId");
            return (Criteria) this;
        }

        public Criteria andCategoryIdNotEqualTo(Integer value) {
            addCriterion("category_id <>", value, "categoryId");
            return (Criteria) this;
        }

        public Criteria andCategoryIdGreaterThan(Integer value) {
            addCriterion("category_id >", value, "categoryId");
            return (Criteria) this;
        }

        public Criteria andCategoryIdGreaterThanOrEqualTo(Integer value) {
            addCriterion("category_id >=", value, "categoryId");
            return (Criteria) this;
        }

        public Criteria andCategoryIdLessThan(Integer value) {
            addCriterion("category_id <", value, "categoryId");
            return (Criteria) this;
        }

        public Criteria andCategoryIdLessThanOrEqualTo(Integer value) {
            addCriterion("category_id <=", value, "categoryId");
            return (Criteria) this;
        }

        public Criteria andCategoryIdIn(List<Integer> values) {
            addCriterion("category_id in", values, "categoryId");
            return (Criteria) this;
        }

        public Criteria andCategoryIdNotIn(List<Integer> values) {
            addCriterion("category_id not in", values, "categoryId");
            return (Criteria) this;
        }

        public Criteria andCategoryIdBetween(Integer value1, Integer value2) {
            addCriterion("category_id between", value1, value2, "categoryId");
            return (Criteria) this;
        }

        public Criteria andCategoryIdNotBetween(Integer value1, Integer value2) {
            addCriterion("category_id not between", value1, value2, "categoryId");
            return (Criteria) this;
        }

        public Criteria andGoodsSnIsNull() {
            addCriterion("goods_sn is null");
            return (Criteria) this;
        }

        public Criteria andGoodsSnIsNotNull() {
            addCriterion("goods_sn is not null");
            return (Criteria) this;
        }

        public Criteria andGoodsSnEqualTo(String value) {
            addCriterion("goods_sn =", value, "goodsSn");
            return (Criteria) this;
        }

        public Criteria andGoodsSnNotEqualTo(String value) {
            addCriterion("goods_sn <>", value, "goodsSn");
            return (Criteria) this;
        }

        public Criteria andGoodsSnGreaterThan(String value) {
            addCriterion("goods_sn >", value, "goodsSn");
            return (Criteria) this;
        }

        public Criteria andGoodsSnGreaterThanOrEqualTo(String value) {
            addCriterion("goods_sn >=", value, "goodsSn");
            return (Criteria) this;
        }

        public Criteria andGoodsSnLessThan(String value) {
            addCriterion("goods_sn <", value, "goodsSn");
            return (Criteria) this;
        }

        public Criteria andGoodsSnLessThanOrEqualTo(String value) {
            addCriterion("goods_sn <=", value, "goodsSn");
            return (Criteria) this;
        }

        public Criteria andGoodsSnLike(String value) {
            addCriterion("goods_sn like", value, "goodsSn");
            return (Criteria) this;
        }

        public Criteria andGoodsSnNotLike(String value) {
            addCriterion("goods_sn not like", value, "goodsSn");
            return (Criteria) this;
        }

        public Criteria andGoodsSnIn(List<String> values) {
            addCriterion("goods_sn in", values, "goodsSn");
            return (Criteria) this;
        }

        public Criteria andGoodsSnNotIn(List<String> values) {
            addCriterion("goods_sn not in", values, "goodsSn");
            return (Criteria) this;
        }

        public Criteria andGoodsSnBetween(String value1, String value2) {
            addCriterion("goods_sn between", value1, value2, "goodsSn");
            return (Criteria) this;
        }

        public Criteria andGoodsSnNotBetween(String value1, String value2) {
            addCriterion("goods_sn not between", value1, value2, "goodsSn");
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

        public Criteria andBrandIdIsNull() {
            addCriterion("brand_id is null");
            return (Criteria) this;
        }

        public Criteria andBrandIdIsNotNull() {
            addCriterion("brand_id is not null");
            return (Criteria) this;
        }

        public Criteria andBrandIdEqualTo(Integer value) {
            addCriterion("brand_id =", value, "brandId");
            return (Criteria) this;
        }

        public Criteria andBrandIdNotEqualTo(Integer value) {
            addCriterion("brand_id <>", value, "brandId");
            return (Criteria) this;
        }

        public Criteria andBrandIdGreaterThan(Integer value) {
            addCriterion("brand_id >", value, "brandId");
            return (Criteria) this;
        }

        public Criteria andBrandIdGreaterThanOrEqualTo(Integer value) {
            addCriterion("brand_id >=", value, "brandId");
            return (Criteria) this;
        }

        public Criteria andBrandIdLessThan(Integer value) {
            addCriterion("brand_id <", value, "brandId");
            return (Criteria) this;
        }

        public Criteria andBrandIdLessThanOrEqualTo(Integer value) {
            addCriterion("brand_id <=", value, "brandId");
            return (Criteria) this;
        }

        public Criteria andBrandIdIn(List<Integer> values) {
            addCriterion("brand_id in", values, "brandId");
            return (Criteria) this;
        }

        public Criteria andBrandIdNotIn(List<Integer> values) {
            addCriterion("brand_id not in", values, "brandId");
            return (Criteria) this;
        }

        public Criteria andBrandIdBetween(Integer value1, Integer value2) {
            addCriterion("brand_id between", value1, value2, "brandId");
            return (Criteria) this;
        }

        public Criteria andBrandIdNotBetween(Integer value1, Integer value2) {
            addCriterion("brand_id not between", value1, value2, "brandId");
            return (Criteria) this;
        }

        public Criteria andGoodsNumberIsNull() {
            addCriterion("goods_number is null");
            return (Criteria) this;
        }

        public Criteria andGoodsNumberIsNotNull() {
            addCriterion("goods_number is not null");
            return (Criteria) this;
        }

        public Criteria andGoodsNumberEqualTo(Integer value) {
            addCriterion("goods_number =", value, "goodsNumber");
            return (Criteria) this;
        }

        public Criteria andGoodsNumberNotEqualTo(Integer value) {
            addCriterion("goods_number <>", value, "goodsNumber");
            return (Criteria) this;
        }

        public Criteria andGoodsNumberGreaterThan(Integer value) {
            addCriterion("goods_number >", value, "goodsNumber");
            return (Criteria) this;
        }

        public Criteria andGoodsNumberGreaterThanOrEqualTo(Integer value) {
            addCriterion("goods_number >=", value, "goodsNumber");
            return (Criteria) this;
        }

        public Criteria andGoodsNumberLessThan(Integer value) {
            addCriterion("goods_number <", value, "goodsNumber");
            return (Criteria) this;
        }

        public Criteria andGoodsNumberLessThanOrEqualTo(Integer value) {
            addCriterion("goods_number <=", value, "goodsNumber");
            return (Criteria) this;
        }

        public Criteria andGoodsNumberIn(List<Integer> values) {
            addCriterion("goods_number in", values, "goodsNumber");
            return (Criteria) this;
        }

        public Criteria andGoodsNumberNotIn(List<Integer> values) {
            addCriterion("goods_number not in", values, "goodsNumber");
            return (Criteria) this;
        }

        public Criteria andGoodsNumberBetween(Integer value1, Integer value2) {
            addCriterion("goods_number between", value1, value2, "goodsNumber");
            return (Criteria) this;
        }

        public Criteria andGoodsNumberNotBetween(Integer value1, Integer value2) {
            addCriterion("goods_number not between", value1, value2, "goodsNumber");
            return (Criteria) this;
        }

        public Criteria andKeywordsIsNull() {
            addCriterion("keywords is null");
            return (Criteria) this;
        }

        public Criteria andKeywordsIsNotNull() {
            addCriterion("keywords is not null");
            return (Criteria) this;
        }

        public Criteria andKeywordsEqualTo(String value) {
            addCriterion("keywords =", value, "keywords");
            return (Criteria) this;
        }

        public Criteria andKeywordsNotEqualTo(String value) {
            addCriterion("keywords <>", value, "keywords");
            return (Criteria) this;
        }

        public Criteria andKeywordsGreaterThan(String value) {
            addCriterion("keywords >", value, "keywords");
            return (Criteria) this;
        }

        public Criteria andKeywordsGreaterThanOrEqualTo(String value) {
            addCriterion("keywords >=", value, "keywords");
            return (Criteria) this;
        }

        public Criteria andKeywordsLessThan(String value) {
            addCriterion("keywords <", value, "keywords");
            return (Criteria) this;
        }

        public Criteria andKeywordsLessThanOrEqualTo(String value) {
            addCriterion("keywords <=", value, "keywords");
            return (Criteria) this;
        }

        public Criteria andKeywordsLike(String value) {
            addCriterion("keywords like", value, "keywords");
            return (Criteria) this;
        }

        public Criteria andKeywordsNotLike(String value) {
            addCriterion("keywords not like", value, "keywords");
            return (Criteria) this;
        }

        public Criteria andKeywordsIn(List<String> values) {
            addCriterion("keywords in", values, "keywords");
            return (Criteria) this;
        }

        public Criteria andKeywordsNotIn(List<String> values) {
            addCriterion("keywords not in", values, "keywords");
            return (Criteria) this;
        }

        public Criteria andKeywordsBetween(String value1, String value2) {
            addCriterion("keywords between", value1, value2, "keywords");
            return (Criteria) this;
        }

        public Criteria andKeywordsNotBetween(String value1, String value2) {
            addCriterion("keywords not between", value1, value2, "keywords");
            return (Criteria) this;
        }

        public Criteria andGoodsBriefIsNull() {
            addCriterion("goods_brief is null");
            return (Criteria) this;
        }

        public Criteria andGoodsBriefIsNotNull() {
            addCriterion("goods_brief is not null");
            return (Criteria) this;
        }

        public Criteria andGoodsBriefEqualTo(String value) {
            addCriterion("goods_brief =", value, "goodsBrief");
            return (Criteria) this;
        }

        public Criteria andGoodsBriefNotEqualTo(String value) {
            addCriterion("goods_brief <>", value, "goodsBrief");
            return (Criteria) this;
        }

        public Criteria andGoodsBriefGreaterThan(String value) {
            addCriterion("goods_brief >", value, "goodsBrief");
            return (Criteria) this;
        }

        public Criteria andGoodsBriefGreaterThanOrEqualTo(String value) {
            addCriterion("goods_brief >=", value, "goodsBrief");
            return (Criteria) this;
        }

        public Criteria andGoodsBriefLessThan(String value) {
            addCriterion("goods_brief <", value, "goodsBrief");
            return (Criteria) this;
        }

        public Criteria andGoodsBriefLessThanOrEqualTo(String value) {
            addCriterion("goods_brief <=", value, "goodsBrief");
            return (Criteria) this;
        }

        public Criteria andGoodsBriefLike(String value) {
            addCriterion("goods_brief like", value, "goodsBrief");
            return (Criteria) this;
        }

        public Criteria andGoodsBriefNotLike(String value) {
            addCriterion("goods_brief not like", value, "goodsBrief");
            return (Criteria) this;
        }

        public Criteria andGoodsBriefIn(List<String> values) {
            addCriterion("goods_brief in", values, "goodsBrief");
            return (Criteria) this;
        }

        public Criteria andGoodsBriefNotIn(List<String> values) {
            addCriterion("goods_brief not in", values, "goodsBrief");
            return (Criteria) this;
        }

        public Criteria andGoodsBriefBetween(String value1, String value2) {
            addCriterion("goods_brief between", value1, value2, "goodsBrief");
            return (Criteria) this;
        }

        public Criteria andGoodsBriefNotBetween(String value1, String value2) {
            addCriterion("goods_brief not between", value1, value2, "goodsBrief");
            return (Criteria) this;
        }

        public Criteria andIsOnSaleIsNull() {
            addCriterion("is_on_sale is null");
            return (Criteria) this;
        }

        public Criteria andIsOnSaleIsNotNull() {
            addCriterion("is_on_sale is not null");
            return (Criteria) this;
        }

        public Criteria andIsOnSaleEqualTo(Boolean value) {
            addCriterion("is_on_sale =", value, "isOnSale");
            return (Criteria) this;
        }

        public Criteria andIsOnSaleNotEqualTo(Boolean value) {
            addCriterion("is_on_sale <>", value, "isOnSale");
            return (Criteria) this;
        }

        public Criteria andIsOnSaleGreaterThan(Boolean value) {
            addCriterion("is_on_sale >", value, "isOnSale");
            return (Criteria) this;
        }

        public Criteria andIsOnSaleGreaterThanOrEqualTo(Boolean value) {
            addCriterion("is_on_sale >=", value, "isOnSale");
            return (Criteria) this;
        }

        public Criteria andIsOnSaleLessThan(Boolean value) {
            addCriterion("is_on_sale <", value, "isOnSale");
            return (Criteria) this;
        }

        public Criteria andIsOnSaleLessThanOrEqualTo(Boolean value) {
            addCriterion("is_on_sale <=", value, "isOnSale");
            return (Criteria) this;
        }

        public Criteria andIsOnSaleIn(List<Boolean> values) {
            addCriterion("is_on_sale in", values, "isOnSale");
            return (Criteria) this;
        }

        public Criteria andIsOnSaleNotIn(List<Boolean> values) {
            addCriterion("is_on_sale not in", values, "isOnSale");
            return (Criteria) this;
        }

        public Criteria andIsOnSaleBetween(Boolean value1, Boolean value2) {
            addCriterion("is_on_sale between", value1, value2, "isOnSale");
            return (Criteria) this;
        }

        public Criteria andIsOnSaleNotBetween(Boolean value1, Boolean value2) {
            addCriterion("is_on_sale not between", value1, value2, "isOnSale");
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

        public Criteria andSortOrderIsNull() {
            addCriterion("sort_order is null");
            return (Criteria) this;
        }

        public Criteria andSortOrderIsNotNull() {
            addCriterion("sort_order is not null");
            return (Criteria) this;
        }

        public Criteria andSortOrderEqualTo(Short value) {
            addCriterion("sort_order =", value, "sortOrder");
            return (Criteria) this;
        }

        public Criteria andSortOrderNotEqualTo(Short value) {
            addCriterion("sort_order <>", value, "sortOrder");
            return (Criteria) this;
        }

        public Criteria andSortOrderGreaterThan(Short value) {
            addCriterion("sort_order >", value, "sortOrder");
            return (Criteria) this;
        }

        public Criteria andSortOrderGreaterThanOrEqualTo(Short value) {
            addCriterion("sort_order >=", value, "sortOrder");
            return (Criteria) this;
        }

        public Criteria andSortOrderLessThan(Short value) {
            addCriterion("sort_order <", value, "sortOrder");
            return (Criteria) this;
        }

        public Criteria andSortOrderLessThanOrEqualTo(Short value) {
            addCriterion("sort_order <=", value, "sortOrder");
            return (Criteria) this;
        }

        public Criteria andSortOrderIn(List<Short> values) {
            addCriterion("sort_order in", values, "sortOrder");
            return (Criteria) this;
        }

        public Criteria andSortOrderNotIn(List<Short> values) {
            addCriterion("sort_order not in", values, "sortOrder");
            return (Criteria) this;
        }

        public Criteria andSortOrderBetween(Short value1, Short value2) {
            addCriterion("sort_order between", value1, value2, "sortOrder");
            return (Criteria) this;
        }

        public Criteria andSortOrderNotBetween(Short value1, Short value2) {
            addCriterion("sort_order not between", value1, value2, "sortOrder");
            return (Criteria) this;
        }

        public Criteria andIsDeleteIsNull() {
            addCriterion("is_delete is null");
            return (Criteria) this;
        }

        public Criteria andIsDeleteIsNotNull() {
            addCriterion("is_delete is not null");
            return (Criteria) this;
        }

        public Criteria andIsDeleteEqualTo(Boolean value) {
            addCriterion("is_delete =", value, "isDelete");
            return (Criteria) this;
        }

        public Criteria andIsDeleteNotEqualTo(Boolean value) {
            addCriterion("is_delete <>", value, "isDelete");
            return (Criteria) this;
        }

        public Criteria andIsDeleteGreaterThan(Boolean value) {
            addCriterion("is_delete >", value, "isDelete");
            return (Criteria) this;
        }

        public Criteria andIsDeleteGreaterThanOrEqualTo(Boolean value) {
            addCriterion("is_delete >=", value, "isDelete");
            return (Criteria) this;
        }

        public Criteria andIsDeleteLessThan(Boolean value) {
            addCriterion("is_delete <", value, "isDelete");
            return (Criteria) this;
        }

        public Criteria andIsDeleteLessThanOrEqualTo(Boolean value) {
            addCriterion("is_delete <=", value, "isDelete");
            return (Criteria) this;
        }

        public Criteria andIsDeleteIn(List<Boolean> values) {
            addCriterion("is_delete in", values, "isDelete");
            return (Criteria) this;
        }

        public Criteria andIsDeleteNotIn(List<Boolean> values) {
            addCriterion("is_delete not in", values, "isDelete");
            return (Criteria) this;
        }

        public Criteria andIsDeleteBetween(Boolean value1, Boolean value2) {
            addCriterion("is_delete between", value1, value2, "isDelete");
            return (Criteria) this;
        }

        public Criteria andIsDeleteNotBetween(Boolean value1, Boolean value2) {
            addCriterion("is_delete not between", value1, value2, "isDelete");
            return (Criteria) this;
        }

        public Criteria andAttributeCategoryIsNull() {
            addCriterion("attribute_category is null");
            return (Criteria) this;
        }

        public Criteria andAttributeCategoryIsNotNull() {
            addCriterion("attribute_category is not null");
            return (Criteria) this;
        }

        public Criteria andAttributeCategoryEqualTo(Integer value) {
            addCriterion("attribute_category =", value, "attributeCategory");
            return (Criteria) this;
        }

        public Criteria andAttributeCategoryNotEqualTo(Integer value) {
            addCriterion("attribute_category <>", value, "attributeCategory");
            return (Criteria) this;
        }

        public Criteria andAttributeCategoryGreaterThan(Integer value) {
            addCriterion("attribute_category >", value, "attributeCategory");
            return (Criteria) this;
        }

        public Criteria andAttributeCategoryGreaterThanOrEqualTo(Integer value) {
            addCriterion("attribute_category >=", value, "attributeCategory");
            return (Criteria) this;
        }

        public Criteria andAttributeCategoryLessThan(Integer value) {
            addCriterion("attribute_category <", value, "attributeCategory");
            return (Criteria) this;
        }

        public Criteria andAttributeCategoryLessThanOrEqualTo(Integer value) {
            addCriterion("attribute_category <=", value, "attributeCategory");
            return (Criteria) this;
        }

        public Criteria andAttributeCategoryIn(List<Integer> values) {
            addCriterion("attribute_category in", values, "attributeCategory");
            return (Criteria) this;
        }

        public Criteria andAttributeCategoryNotIn(List<Integer> values) {
            addCriterion("attribute_category not in", values, "attributeCategory");
            return (Criteria) this;
        }

        public Criteria andAttributeCategoryBetween(Integer value1, Integer value2) {
            addCriterion("attribute_category between", value1, value2, "attributeCategory");
            return (Criteria) this;
        }

        public Criteria andAttributeCategoryNotBetween(Integer value1, Integer value2) {
            addCriterion("attribute_category not between", value1, value2, "attributeCategory");
            return (Criteria) this;
        }

        public Criteria andCounterPriceIsNull() {
            addCriterion("counter_price is null");
            return (Criteria) this;
        }

        public Criteria andCounterPriceIsNotNull() {
            addCriterion("counter_price is not null");
            return (Criteria) this;
        }

        public Criteria andCounterPriceEqualTo(BigDecimal value) {
            addCriterion("counter_price =", value, "counterPrice");
            return (Criteria) this;
        }

        public Criteria andCounterPriceNotEqualTo(BigDecimal value) {
            addCriterion("counter_price <>", value, "counterPrice");
            return (Criteria) this;
        }

        public Criteria andCounterPriceGreaterThan(BigDecimal value) {
            addCriterion("counter_price >", value, "counterPrice");
            return (Criteria) this;
        }

        public Criteria andCounterPriceGreaterThanOrEqualTo(BigDecimal value) {
            addCriterion("counter_price >=", value, "counterPrice");
            return (Criteria) this;
        }

        public Criteria andCounterPriceLessThan(BigDecimal value) {
            addCriterion("counter_price <", value, "counterPrice");
            return (Criteria) this;
        }

        public Criteria andCounterPriceLessThanOrEqualTo(BigDecimal value) {
            addCriterion("counter_price <=", value, "counterPrice");
            return (Criteria) this;
        }

        public Criteria andCounterPriceIn(List<BigDecimal> values) {
            addCriterion("counter_price in", values, "counterPrice");
            return (Criteria) this;
        }

        public Criteria andCounterPriceNotIn(List<BigDecimal> values) {
            addCriterion("counter_price not in", values, "counterPrice");
            return (Criteria) this;
        }

        public Criteria andCounterPriceBetween(BigDecimal value1, BigDecimal value2) {
            addCriterion("counter_price between", value1, value2, "counterPrice");
            return (Criteria) this;
        }

        public Criteria andCounterPriceNotBetween(BigDecimal value1, BigDecimal value2) {
            addCriterion("counter_price not between", value1, value2, "counterPrice");
            return (Criteria) this;
        }

        public Criteria andExtraPriceIsNull() {
            addCriterion("extra_price is null");
            return (Criteria) this;
        }

        public Criteria andExtraPriceIsNotNull() {
            addCriterion("extra_price is not null");
            return (Criteria) this;
        }

        public Criteria andExtraPriceEqualTo(BigDecimal value) {
            addCriterion("extra_price =", value, "extraPrice");
            return (Criteria) this;
        }

        public Criteria andExtraPriceNotEqualTo(BigDecimal value) {
            addCriterion("extra_price <>", value, "extraPrice");
            return (Criteria) this;
        }

        public Criteria andExtraPriceGreaterThan(BigDecimal value) {
            addCriterion("extra_price >", value, "extraPrice");
            return (Criteria) this;
        }

        public Criteria andExtraPriceGreaterThanOrEqualTo(BigDecimal value) {
            addCriterion("extra_price >=", value, "extraPrice");
            return (Criteria) this;
        }

        public Criteria andExtraPriceLessThan(BigDecimal value) {
            addCriterion("extra_price <", value, "extraPrice");
            return (Criteria) this;
        }

        public Criteria andExtraPriceLessThanOrEqualTo(BigDecimal value) {
            addCriterion("extra_price <=", value, "extraPrice");
            return (Criteria) this;
        }

        public Criteria andExtraPriceIn(List<BigDecimal> values) {
            addCriterion("extra_price in", values, "extraPrice");
            return (Criteria) this;
        }

        public Criteria andExtraPriceNotIn(List<BigDecimal> values) {
            addCriterion("extra_price not in", values, "extraPrice");
            return (Criteria) this;
        }

        public Criteria andExtraPriceBetween(BigDecimal value1, BigDecimal value2) {
            addCriterion("extra_price between", value1, value2, "extraPrice");
            return (Criteria) this;
        }

        public Criteria andExtraPriceNotBetween(BigDecimal value1, BigDecimal value2) {
            addCriterion("extra_price not between", value1, value2, "extraPrice");
            return (Criteria) this;
        }

        public Criteria andIsNewIsNull() {
            addCriterion("is_new is null");
            return (Criteria) this;
        }

        public Criteria andIsNewIsNotNull() {
            addCriterion("is_new is not null");
            return (Criteria) this;
        }

        public Criteria andIsNewEqualTo(Boolean value) {
            addCriterion("is_new =", value, "isNew");
            return (Criteria) this;
        }

        public Criteria andIsNewNotEqualTo(Boolean value) {
            addCriterion("is_new <>", value, "isNew");
            return (Criteria) this;
        }

        public Criteria andIsNewGreaterThan(Boolean value) {
            addCriterion("is_new >", value, "isNew");
            return (Criteria) this;
        }

        public Criteria andIsNewGreaterThanOrEqualTo(Boolean value) {
            addCriterion("is_new >=", value, "isNew");
            return (Criteria) this;
        }

        public Criteria andIsNewLessThan(Boolean value) {
            addCriterion("is_new <", value, "isNew");
            return (Criteria) this;
        }

        public Criteria andIsNewLessThanOrEqualTo(Boolean value) {
            addCriterion("is_new <=", value, "isNew");
            return (Criteria) this;
        }

        public Criteria andIsNewIn(List<Boolean> values) {
            addCriterion("is_new in", values, "isNew");
            return (Criteria) this;
        }

        public Criteria andIsNewNotIn(List<Boolean> values) {
            addCriterion("is_new not in", values, "isNew");
            return (Criteria) this;
        }

        public Criteria andIsNewBetween(Boolean value1, Boolean value2) {
            addCriterion("is_new between", value1, value2, "isNew");
            return (Criteria) this;
        }

        public Criteria andIsNewNotBetween(Boolean value1, Boolean value2) {
            addCriterion("is_new not between", value1, value2, "isNew");
            return (Criteria) this;
        }

        public Criteria andGoodsUnitIsNull() {
            addCriterion("goods_unit is null");
            return (Criteria) this;
        }

        public Criteria andGoodsUnitIsNotNull() {
            addCriterion("goods_unit is not null");
            return (Criteria) this;
        }

        public Criteria andGoodsUnitEqualTo(String value) {
            addCriterion("goods_unit =", value, "goodsUnit");
            return (Criteria) this;
        }

        public Criteria andGoodsUnitNotEqualTo(String value) {
            addCriterion("goods_unit <>", value, "goodsUnit");
            return (Criteria) this;
        }

        public Criteria andGoodsUnitGreaterThan(String value) {
            addCriterion("goods_unit >", value, "goodsUnit");
            return (Criteria) this;
        }

        public Criteria andGoodsUnitGreaterThanOrEqualTo(String value) {
            addCriterion("goods_unit >=", value, "goodsUnit");
            return (Criteria) this;
        }

        public Criteria andGoodsUnitLessThan(String value) {
            addCriterion("goods_unit <", value, "goodsUnit");
            return (Criteria) this;
        }

        public Criteria andGoodsUnitLessThanOrEqualTo(String value) {
            addCriterion("goods_unit <=", value, "goodsUnit");
            return (Criteria) this;
        }

        public Criteria andGoodsUnitLike(String value) {
            addCriterion("goods_unit like", value, "goodsUnit");
            return (Criteria) this;
        }

        public Criteria andGoodsUnitNotLike(String value) {
            addCriterion("goods_unit not like", value, "goodsUnit");
            return (Criteria) this;
        }

        public Criteria andGoodsUnitIn(List<String> values) {
            addCriterion("goods_unit in", values, "goodsUnit");
            return (Criteria) this;
        }

        public Criteria andGoodsUnitNotIn(List<String> values) {
            addCriterion("goods_unit not in", values, "goodsUnit");
            return (Criteria) this;
        }

        public Criteria andGoodsUnitBetween(String value1, String value2) {
            addCriterion("goods_unit between", value1, value2, "goodsUnit");
            return (Criteria) this;
        }

        public Criteria andGoodsUnitNotBetween(String value1, String value2) {
            addCriterion("goods_unit not between", value1, value2, "goodsUnit");
            return (Criteria) this;
        }

        public Criteria andPrimaryPicUrlIsNull() {
            addCriterion("primary_pic_url is null");
            return (Criteria) this;
        }

        public Criteria andPrimaryPicUrlIsNotNull() {
            addCriterion("primary_pic_url is not null");
            return (Criteria) this;
        }

        public Criteria andPrimaryPicUrlEqualTo(String value) {
            addCriterion("primary_pic_url =", value, "primaryPicUrl");
            return (Criteria) this;
        }

        public Criteria andPrimaryPicUrlNotEqualTo(String value) {
            addCriterion("primary_pic_url <>", value, "primaryPicUrl");
            return (Criteria) this;
        }

        public Criteria andPrimaryPicUrlGreaterThan(String value) {
            addCriterion("primary_pic_url >", value, "primaryPicUrl");
            return (Criteria) this;
        }

        public Criteria andPrimaryPicUrlGreaterThanOrEqualTo(String value) {
            addCriterion("primary_pic_url >=", value, "primaryPicUrl");
            return (Criteria) this;
        }

        public Criteria andPrimaryPicUrlLessThan(String value) {
            addCriterion("primary_pic_url <", value, "primaryPicUrl");
            return (Criteria) this;
        }

        public Criteria andPrimaryPicUrlLessThanOrEqualTo(String value) {
            addCriterion("primary_pic_url <=", value, "primaryPicUrl");
            return (Criteria) this;
        }

        public Criteria andPrimaryPicUrlLike(String value) {
            addCriterion("primary_pic_url like", value, "primaryPicUrl");
            return (Criteria) this;
        }

        public Criteria andPrimaryPicUrlNotLike(String value) {
            addCriterion("primary_pic_url not like", value, "primaryPicUrl");
            return (Criteria) this;
        }

        public Criteria andPrimaryPicUrlIn(List<String> values) {
            addCriterion("primary_pic_url in", values, "primaryPicUrl");
            return (Criteria) this;
        }

        public Criteria andPrimaryPicUrlNotIn(List<String> values) {
            addCriterion("primary_pic_url not in", values, "primaryPicUrl");
            return (Criteria) this;
        }

        public Criteria andPrimaryPicUrlBetween(String value1, String value2) {
            addCriterion("primary_pic_url between", value1, value2, "primaryPicUrl");
            return (Criteria) this;
        }

        public Criteria andPrimaryPicUrlNotBetween(String value1, String value2) {
            addCriterion("primary_pic_url not between", value1, value2, "primaryPicUrl");
            return (Criteria) this;
        }

        public Criteria andListPicUrlIsNull() {
            addCriterion("list_pic_url is null");
            return (Criteria) this;
        }

        public Criteria andListPicUrlIsNotNull() {
            addCriterion("list_pic_url is not null");
            return (Criteria) this;
        }

        public Criteria andListPicUrlEqualTo(String value) {
            addCriterion("list_pic_url =", value, "listPicUrl");
            return (Criteria) this;
        }

        public Criteria andListPicUrlNotEqualTo(String value) {
            addCriterion("list_pic_url <>", value, "listPicUrl");
            return (Criteria) this;
        }

        public Criteria andListPicUrlGreaterThan(String value) {
            addCriterion("list_pic_url >", value, "listPicUrl");
            return (Criteria) this;
        }

        public Criteria andListPicUrlGreaterThanOrEqualTo(String value) {
            addCriterion("list_pic_url >=", value, "listPicUrl");
            return (Criteria) this;
        }

        public Criteria andListPicUrlLessThan(String value) {
            addCriterion("list_pic_url <", value, "listPicUrl");
            return (Criteria) this;
        }

        public Criteria andListPicUrlLessThanOrEqualTo(String value) {
            addCriterion("list_pic_url <=", value, "listPicUrl");
            return (Criteria) this;
        }

        public Criteria andListPicUrlLike(String value) {
            addCriterion("list_pic_url like", value, "listPicUrl");
            return (Criteria) this;
        }

        public Criteria andListPicUrlNotLike(String value) {
            addCriterion("list_pic_url not like", value, "listPicUrl");
            return (Criteria) this;
        }

        public Criteria andListPicUrlIn(List<String> values) {
            addCriterion("list_pic_url in", values, "listPicUrl");
            return (Criteria) this;
        }

        public Criteria andListPicUrlNotIn(List<String> values) {
            addCriterion("list_pic_url not in", values, "listPicUrl");
            return (Criteria) this;
        }

        public Criteria andListPicUrlBetween(String value1, String value2) {
            addCriterion("list_pic_url between", value1, value2, "listPicUrl");
            return (Criteria) this;
        }

        public Criteria andListPicUrlNotBetween(String value1, String value2) {
            addCriterion("list_pic_url not between", value1, value2, "listPicUrl");
            return (Criteria) this;
        }

        public Criteria andRetailPriceIsNull() {
            addCriterion("retail_price is null");
            return (Criteria) this;
        }

        public Criteria andRetailPriceIsNotNull() {
            addCriterion("retail_price is not null");
            return (Criteria) this;
        }

        public Criteria andRetailPriceEqualTo(BigDecimal value) {
            addCriterion("retail_price =", value, "retailPrice");
            return (Criteria) this;
        }

        public Criteria andRetailPriceNotEqualTo(BigDecimal value) {
            addCriterion("retail_price <>", value, "retailPrice");
            return (Criteria) this;
        }

        public Criteria andRetailPriceGreaterThan(BigDecimal value) {
            addCriterion("retail_price >", value, "retailPrice");
            return (Criteria) this;
        }

        public Criteria andRetailPriceGreaterThanOrEqualTo(BigDecimal value) {
            addCriterion("retail_price >=", value, "retailPrice");
            return (Criteria) this;
        }

        public Criteria andRetailPriceLessThan(BigDecimal value) {
            addCriterion("retail_price <", value, "retailPrice");
            return (Criteria) this;
        }

        public Criteria andRetailPriceLessThanOrEqualTo(BigDecimal value) {
            addCriterion("retail_price <=", value, "retailPrice");
            return (Criteria) this;
        }

        public Criteria andRetailPriceIn(List<BigDecimal> values) {
            addCriterion("retail_price in", values, "retailPrice");
            return (Criteria) this;
        }

        public Criteria andRetailPriceNotIn(List<BigDecimal> values) {
            addCriterion("retail_price not in", values, "retailPrice");
            return (Criteria) this;
        }

        public Criteria andRetailPriceBetween(BigDecimal value1, BigDecimal value2) {
            addCriterion("retail_price between", value1, value2, "retailPrice");
            return (Criteria) this;
        }

        public Criteria andRetailPriceNotBetween(BigDecimal value1, BigDecimal value2) {
            addCriterion("retail_price not between", value1, value2, "retailPrice");
            return (Criteria) this;
        }

        public Criteria andSellVolumeIsNull() {
            addCriterion("sell_volume is null");
            return (Criteria) this;
        }

        public Criteria andSellVolumeIsNotNull() {
            addCriterion("sell_volume is not null");
            return (Criteria) this;
        }

        public Criteria andSellVolumeEqualTo(Integer value) {
            addCriterion("sell_volume =", value, "sellVolume");
            return (Criteria) this;
        }

        public Criteria andSellVolumeNotEqualTo(Integer value) {
            addCriterion("sell_volume <>", value, "sellVolume");
            return (Criteria) this;
        }

        public Criteria andSellVolumeGreaterThan(Integer value) {
            addCriterion("sell_volume >", value, "sellVolume");
            return (Criteria) this;
        }

        public Criteria andSellVolumeGreaterThanOrEqualTo(Integer value) {
            addCriterion("sell_volume >=", value, "sellVolume");
            return (Criteria) this;
        }

        public Criteria andSellVolumeLessThan(Integer value) {
            addCriterion("sell_volume <", value, "sellVolume");
            return (Criteria) this;
        }

        public Criteria andSellVolumeLessThanOrEqualTo(Integer value) {
            addCriterion("sell_volume <=", value, "sellVolume");
            return (Criteria) this;
        }

        public Criteria andSellVolumeIn(List<Integer> values) {
            addCriterion("sell_volume in", values, "sellVolume");
            return (Criteria) this;
        }

        public Criteria andSellVolumeNotIn(List<Integer> values) {
            addCriterion("sell_volume not in", values, "sellVolume");
            return (Criteria) this;
        }

        public Criteria andSellVolumeBetween(Integer value1, Integer value2) {
            addCriterion("sell_volume between", value1, value2, "sellVolume");
            return (Criteria) this;
        }

        public Criteria andSellVolumeNotBetween(Integer value1, Integer value2) {
            addCriterion("sell_volume not between", value1, value2, "sellVolume");
            return (Criteria) this;
        }

        public Criteria andPrimaryProductIdIsNull() {
            addCriterion("primary_product_id is null");
            return (Criteria) this;
        }

        public Criteria andPrimaryProductIdIsNotNull() {
            addCriterion("primary_product_id is not null");
            return (Criteria) this;
        }

        public Criteria andPrimaryProductIdEqualTo(Integer value) {
            addCriterion("primary_product_id =", value, "primaryProductId");
            return (Criteria) this;
        }

        public Criteria andPrimaryProductIdNotEqualTo(Integer value) {
            addCriterion("primary_product_id <>", value, "primaryProductId");
            return (Criteria) this;
        }

        public Criteria andPrimaryProductIdGreaterThan(Integer value) {
            addCriterion("primary_product_id >", value, "primaryProductId");
            return (Criteria) this;
        }

        public Criteria andPrimaryProductIdGreaterThanOrEqualTo(Integer value) {
            addCriterion("primary_product_id >=", value, "primaryProductId");
            return (Criteria) this;
        }

        public Criteria andPrimaryProductIdLessThan(Integer value) {
            addCriterion("primary_product_id <", value, "primaryProductId");
            return (Criteria) this;
        }

        public Criteria andPrimaryProductIdLessThanOrEqualTo(Integer value) {
            addCriterion("primary_product_id <=", value, "primaryProductId");
            return (Criteria) this;
        }

        public Criteria andPrimaryProductIdIn(List<Integer> values) {
            addCriterion("primary_product_id in", values, "primaryProductId");
            return (Criteria) this;
        }

        public Criteria andPrimaryProductIdNotIn(List<Integer> values) {
            addCriterion("primary_product_id not in", values, "primaryProductId");
            return (Criteria) this;
        }

        public Criteria andPrimaryProductIdBetween(Integer value1, Integer value2) {
            addCriterion("primary_product_id between", value1, value2, "primaryProductId");
            return (Criteria) this;
        }

        public Criteria andPrimaryProductIdNotBetween(Integer value1, Integer value2) {
            addCriterion("primary_product_id not between", value1, value2, "primaryProductId");
            return (Criteria) this;
        }

        public Criteria andUnitPriceIsNull() {
            addCriterion("unit_price is null");
            return (Criteria) this;
        }

        public Criteria andUnitPriceIsNotNull() {
            addCriterion("unit_price is not null");
            return (Criteria) this;
        }

        public Criteria andUnitPriceEqualTo(BigDecimal value) {
            addCriterion("unit_price =", value, "unitPrice");
            return (Criteria) this;
        }

        public Criteria andUnitPriceNotEqualTo(BigDecimal value) {
            addCriterion("unit_price <>", value, "unitPrice");
            return (Criteria) this;
        }

        public Criteria andUnitPriceGreaterThan(BigDecimal value) {
            addCriterion("unit_price >", value, "unitPrice");
            return (Criteria) this;
        }

        public Criteria andUnitPriceGreaterThanOrEqualTo(BigDecimal value) {
            addCriterion("unit_price >=", value, "unitPrice");
            return (Criteria) this;
        }

        public Criteria andUnitPriceLessThan(BigDecimal value) {
            addCriterion("unit_price <", value, "unitPrice");
            return (Criteria) this;
        }

        public Criteria andUnitPriceLessThanOrEqualTo(BigDecimal value) {
            addCriterion("unit_price <=", value, "unitPrice");
            return (Criteria) this;
        }

        public Criteria andUnitPriceIn(List<BigDecimal> values) {
            addCriterion("unit_price in", values, "unitPrice");
            return (Criteria) this;
        }

        public Criteria andUnitPriceNotIn(List<BigDecimal> values) {
            addCriterion("unit_price not in", values, "unitPrice");
            return (Criteria) this;
        }

        public Criteria andUnitPriceBetween(BigDecimal value1, BigDecimal value2) {
            addCriterion("unit_price between", value1, value2, "unitPrice");
            return (Criteria) this;
        }

        public Criteria andUnitPriceNotBetween(BigDecimal value1, BigDecimal value2) {
            addCriterion("unit_price not between", value1, value2, "unitPrice");
            return (Criteria) this;
        }

        public Criteria andPromotionDescIsNull() {
            addCriterion("promotion_desc is null");
            return (Criteria) this;
        }

        public Criteria andPromotionDescIsNotNull() {
            addCriterion("promotion_desc is not null");
            return (Criteria) this;
        }

        public Criteria andPromotionDescEqualTo(String value) {
            addCriterion("promotion_desc =", value, "promotionDesc");
            return (Criteria) this;
        }

        public Criteria andPromotionDescNotEqualTo(String value) {
            addCriterion("promotion_desc <>", value, "promotionDesc");
            return (Criteria) this;
        }

        public Criteria andPromotionDescGreaterThan(String value) {
            addCriterion("promotion_desc >", value, "promotionDesc");
            return (Criteria) this;
        }

        public Criteria andPromotionDescGreaterThanOrEqualTo(String value) {
            addCriterion("promotion_desc >=", value, "promotionDesc");
            return (Criteria) this;
        }

        public Criteria andPromotionDescLessThan(String value) {
            addCriterion("promotion_desc <", value, "promotionDesc");
            return (Criteria) this;
        }

        public Criteria andPromotionDescLessThanOrEqualTo(String value) {
            addCriterion("promotion_desc <=", value, "promotionDesc");
            return (Criteria) this;
        }

        public Criteria andPromotionDescLike(String value) {
            addCriterion("promotion_desc like", value, "promotionDesc");
            return (Criteria) this;
        }

        public Criteria andPromotionDescNotLike(String value) {
            addCriterion("promotion_desc not like", value, "promotionDesc");
            return (Criteria) this;
        }

        public Criteria andPromotionDescIn(List<String> values) {
            addCriterion("promotion_desc in", values, "promotionDesc");
            return (Criteria) this;
        }

        public Criteria andPromotionDescNotIn(List<String> values) {
            addCriterion("promotion_desc not in", values, "promotionDesc");
            return (Criteria) this;
        }

        public Criteria andPromotionDescBetween(String value1, String value2) {
            addCriterion("promotion_desc between", value1, value2, "promotionDesc");
            return (Criteria) this;
        }

        public Criteria andPromotionDescNotBetween(String value1, String value2) {
            addCriterion("promotion_desc not between", value1, value2, "promotionDesc");
            return (Criteria) this;
        }

        public Criteria andPromotionTagIsNull() {
            addCriterion("promotion_tag is null");
            return (Criteria) this;
        }

        public Criteria andPromotionTagIsNotNull() {
            addCriterion("promotion_tag is not null");
            return (Criteria) this;
        }

        public Criteria andPromotionTagEqualTo(String value) {
            addCriterion("promotion_tag =", value, "promotionTag");
            return (Criteria) this;
        }

        public Criteria andPromotionTagNotEqualTo(String value) {
            addCriterion("promotion_tag <>", value, "promotionTag");
            return (Criteria) this;
        }

        public Criteria andPromotionTagGreaterThan(String value) {
            addCriterion("promotion_tag >", value, "promotionTag");
            return (Criteria) this;
        }

        public Criteria andPromotionTagGreaterThanOrEqualTo(String value) {
            addCriterion("promotion_tag >=", value, "promotionTag");
            return (Criteria) this;
        }

        public Criteria andPromotionTagLessThan(String value) {
            addCriterion("promotion_tag <", value, "promotionTag");
            return (Criteria) this;
        }

        public Criteria andPromotionTagLessThanOrEqualTo(String value) {
            addCriterion("promotion_tag <=", value, "promotionTag");
            return (Criteria) this;
        }

        public Criteria andPromotionTagLike(String value) {
            addCriterion("promotion_tag like", value, "promotionTag");
            return (Criteria) this;
        }

        public Criteria andPromotionTagNotLike(String value) {
            addCriterion("promotion_tag not like", value, "promotionTag");
            return (Criteria) this;
        }

        public Criteria andPromotionTagIn(List<String> values) {
            addCriterion("promotion_tag in", values, "promotionTag");
            return (Criteria) this;
        }

        public Criteria andPromotionTagNotIn(List<String> values) {
            addCriterion("promotion_tag not in", values, "promotionTag");
            return (Criteria) this;
        }

        public Criteria andPromotionTagBetween(String value1, String value2) {
            addCriterion("promotion_tag between", value1, value2, "promotionTag");
            return (Criteria) this;
        }

        public Criteria andPromotionTagNotBetween(String value1, String value2) {
            addCriterion("promotion_tag not between", value1, value2, "promotionTag");
            return (Criteria) this;
        }

        public Criteria andAppExclusivePriceIsNull() {
            addCriterion("app_exclusive_price is null");
            return (Criteria) this;
        }

        public Criteria andAppExclusivePriceIsNotNull() {
            addCriterion("app_exclusive_price is not null");
            return (Criteria) this;
        }

        public Criteria andAppExclusivePriceEqualTo(BigDecimal value) {
            addCriterion("app_exclusive_price =", value, "appExclusivePrice");
            return (Criteria) this;
        }

        public Criteria andAppExclusivePriceNotEqualTo(BigDecimal value) {
            addCriterion("app_exclusive_price <>", value, "appExclusivePrice");
            return (Criteria) this;
        }

        public Criteria andAppExclusivePriceGreaterThan(BigDecimal value) {
            addCriterion("app_exclusive_price >", value, "appExclusivePrice");
            return (Criteria) this;
        }

        public Criteria andAppExclusivePriceGreaterThanOrEqualTo(BigDecimal value) {
            addCriterion("app_exclusive_price >=", value, "appExclusivePrice");
            return (Criteria) this;
        }

        public Criteria andAppExclusivePriceLessThan(BigDecimal value) {
            addCriterion("app_exclusive_price <", value, "appExclusivePrice");
            return (Criteria) this;
        }

        public Criteria andAppExclusivePriceLessThanOrEqualTo(BigDecimal value) {
            addCriterion("app_exclusive_price <=", value, "appExclusivePrice");
            return (Criteria) this;
        }

        public Criteria andAppExclusivePriceIn(List<BigDecimal> values) {
            addCriterion("app_exclusive_price in", values, "appExclusivePrice");
            return (Criteria) this;
        }

        public Criteria andAppExclusivePriceNotIn(List<BigDecimal> values) {
            addCriterion("app_exclusive_price not in", values, "appExclusivePrice");
            return (Criteria) this;
        }

        public Criteria andAppExclusivePriceBetween(BigDecimal value1, BigDecimal value2) {
            addCriterion("app_exclusive_price between", value1, value2, "appExclusivePrice");
            return (Criteria) this;
        }

        public Criteria andAppExclusivePriceNotBetween(BigDecimal value1, BigDecimal value2) {
            addCriterion("app_exclusive_price not between", value1, value2, "appExclusivePrice");
            return (Criteria) this;
        }

        public Criteria andIsAppExclusiveIsNull() {
            addCriterion("is_app_exclusive is null");
            return (Criteria) this;
        }

        public Criteria andIsAppExclusiveIsNotNull() {
            addCriterion("is_app_exclusive is not null");
            return (Criteria) this;
        }

        public Criteria andIsAppExclusiveEqualTo(Boolean value) {
            addCriterion("is_app_exclusive =", value, "isAppExclusive");
            return (Criteria) this;
        }

        public Criteria andIsAppExclusiveNotEqualTo(Boolean value) {
            addCriterion("is_app_exclusive <>", value, "isAppExclusive");
            return (Criteria) this;
        }

        public Criteria andIsAppExclusiveGreaterThan(Boolean value) {
            addCriterion("is_app_exclusive >", value, "isAppExclusive");
            return (Criteria) this;
        }

        public Criteria andIsAppExclusiveGreaterThanOrEqualTo(Boolean value) {
            addCriterion("is_app_exclusive >=", value, "isAppExclusive");
            return (Criteria) this;
        }

        public Criteria andIsAppExclusiveLessThan(Boolean value) {
            addCriterion("is_app_exclusive <", value, "isAppExclusive");
            return (Criteria) this;
        }

        public Criteria andIsAppExclusiveLessThanOrEqualTo(Boolean value) {
            addCriterion("is_app_exclusive <=", value, "isAppExclusive");
            return (Criteria) this;
        }

        public Criteria andIsAppExclusiveIn(List<Boolean> values) {
            addCriterion("is_app_exclusive in", values, "isAppExclusive");
            return (Criteria) this;
        }

        public Criteria andIsAppExclusiveNotIn(List<Boolean> values) {
            addCriterion("is_app_exclusive not in", values, "isAppExclusive");
            return (Criteria) this;
        }

        public Criteria andIsAppExclusiveBetween(Boolean value1, Boolean value2) {
            addCriterion("is_app_exclusive between", value1, value2, "isAppExclusive");
            return (Criteria) this;
        }

        public Criteria andIsAppExclusiveNotBetween(Boolean value1, Boolean value2) {
            addCriterion("is_app_exclusive not between", value1, value2, "isAppExclusive");
            return (Criteria) this;
        }

        public Criteria andIsLimitedIsNull() {
            addCriterion("is_limited is null");
            return (Criteria) this;
        }

        public Criteria andIsLimitedIsNotNull() {
            addCriterion("is_limited is not null");
            return (Criteria) this;
        }

        public Criteria andIsLimitedEqualTo(Boolean value) {
            addCriterion("is_limited =", value, "isLimited");
            return (Criteria) this;
        }

        public Criteria andIsLimitedNotEqualTo(Boolean value) {
            addCriterion("is_limited <>", value, "isLimited");
            return (Criteria) this;
        }

        public Criteria andIsLimitedGreaterThan(Boolean value) {
            addCriterion("is_limited >", value, "isLimited");
            return (Criteria) this;
        }

        public Criteria andIsLimitedGreaterThanOrEqualTo(Boolean value) {
            addCriterion("is_limited >=", value, "isLimited");
            return (Criteria) this;
        }

        public Criteria andIsLimitedLessThan(Boolean value) {
            addCriterion("is_limited <", value, "isLimited");
            return (Criteria) this;
        }

        public Criteria andIsLimitedLessThanOrEqualTo(Boolean value) {
            addCriterion("is_limited <=", value, "isLimited");
            return (Criteria) this;
        }

        public Criteria andIsLimitedIn(List<Boolean> values) {
            addCriterion("is_limited in", values, "isLimited");
            return (Criteria) this;
        }

        public Criteria andIsLimitedNotIn(List<Boolean> values) {
            addCriterion("is_limited not in", values, "isLimited");
            return (Criteria) this;
        }

        public Criteria andIsLimitedBetween(Boolean value1, Boolean value2) {
            addCriterion("is_limited between", value1, value2, "isLimited");
            return (Criteria) this;
        }

        public Criteria andIsLimitedNotBetween(Boolean value1, Boolean value2) {
            addCriterion("is_limited not between", value1, value2, "isLimited");
            return (Criteria) this;
        }

        public Criteria andIsHotIsNull() {
            addCriterion("is_hot is null");
            return (Criteria) this;
        }

        public Criteria andIsHotIsNotNull() {
            addCriterion("is_hot is not null");
            return (Criteria) this;
        }

        public Criteria andIsHotEqualTo(Boolean value) {
            addCriterion("is_hot =", value, "isHot");
            return (Criteria) this;
        }

        public Criteria andIsHotNotEqualTo(Boolean value) {
            addCriterion("is_hot <>", value, "isHot");
            return (Criteria) this;
        }

        public Criteria andIsHotGreaterThan(Boolean value) {
            addCriterion("is_hot >", value, "isHot");
            return (Criteria) this;
        }

        public Criteria andIsHotGreaterThanOrEqualTo(Boolean value) {
            addCriterion("is_hot >=", value, "isHot");
            return (Criteria) this;
        }

        public Criteria andIsHotLessThan(Boolean value) {
            addCriterion("is_hot <", value, "isHot");
            return (Criteria) this;
        }

        public Criteria andIsHotLessThanOrEqualTo(Boolean value) {
            addCriterion("is_hot <=", value, "isHot");
            return (Criteria) this;
        }

        public Criteria andIsHotIn(List<Boolean> values) {
            addCriterion("is_hot in", values, "isHot");
            return (Criteria) this;
        }

        public Criteria andIsHotNotIn(List<Boolean> values) {
            addCriterion("is_hot not in", values, "isHot");
            return (Criteria) this;
        }

        public Criteria andIsHotBetween(Boolean value1, Boolean value2) {
            addCriterion("is_hot between", value1, value2, "isHot");
            return (Criteria) this;
        }

        public Criteria andIsHotNotBetween(Boolean value1, Boolean value2) {
            addCriterion("is_hot not between", value1, value2, "isHot");
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