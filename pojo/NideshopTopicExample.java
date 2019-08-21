package net.messi.early.pojo;

import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.List;

public class NideshopTopicExample {
    protected String orderByClause;

    protected boolean distinct;

    protected List<Criteria> oredCriteria;

    public NideshopTopicExample() {
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

        public Criteria andAvatarIsNull() {
            addCriterion("avatar is null");
            return (Criteria) this;
        }

        public Criteria andAvatarIsNotNull() {
            addCriterion("avatar is not null");
            return (Criteria) this;
        }

        public Criteria andAvatarEqualTo(String value) {
            addCriterion("avatar =", value, "avatar");
            return (Criteria) this;
        }

        public Criteria andAvatarNotEqualTo(String value) {
            addCriterion("avatar <>", value, "avatar");
            return (Criteria) this;
        }

        public Criteria andAvatarGreaterThan(String value) {
            addCriterion("avatar >", value, "avatar");
            return (Criteria) this;
        }

        public Criteria andAvatarGreaterThanOrEqualTo(String value) {
            addCriterion("avatar >=", value, "avatar");
            return (Criteria) this;
        }

        public Criteria andAvatarLessThan(String value) {
            addCriterion("avatar <", value, "avatar");
            return (Criteria) this;
        }

        public Criteria andAvatarLessThanOrEqualTo(String value) {
            addCriterion("avatar <=", value, "avatar");
            return (Criteria) this;
        }

        public Criteria andAvatarLike(String value) {
            addCriterion("avatar like", value, "avatar");
            return (Criteria) this;
        }

        public Criteria andAvatarNotLike(String value) {
            addCriterion("avatar not like", value, "avatar");
            return (Criteria) this;
        }

        public Criteria andAvatarIn(List<String> values) {
            addCriterion("avatar in", values, "avatar");
            return (Criteria) this;
        }

        public Criteria andAvatarNotIn(List<String> values) {
            addCriterion("avatar not in", values, "avatar");
            return (Criteria) this;
        }

        public Criteria andAvatarBetween(String value1, String value2) {
            addCriterion("avatar between", value1, value2, "avatar");
            return (Criteria) this;
        }

        public Criteria andAvatarNotBetween(String value1, String value2) {
            addCriterion("avatar not between", value1, value2, "avatar");
            return (Criteria) this;
        }

        public Criteria andItemPicUrlIsNull() {
            addCriterion("item_pic_url is null");
            return (Criteria) this;
        }

        public Criteria andItemPicUrlIsNotNull() {
            addCriterion("item_pic_url is not null");
            return (Criteria) this;
        }

        public Criteria andItemPicUrlEqualTo(String value) {
            addCriterion("item_pic_url =", value, "itemPicUrl");
            return (Criteria) this;
        }

        public Criteria andItemPicUrlNotEqualTo(String value) {
            addCriterion("item_pic_url <>", value, "itemPicUrl");
            return (Criteria) this;
        }

        public Criteria andItemPicUrlGreaterThan(String value) {
            addCriterion("item_pic_url >", value, "itemPicUrl");
            return (Criteria) this;
        }

        public Criteria andItemPicUrlGreaterThanOrEqualTo(String value) {
            addCriterion("item_pic_url >=", value, "itemPicUrl");
            return (Criteria) this;
        }

        public Criteria andItemPicUrlLessThan(String value) {
            addCriterion("item_pic_url <", value, "itemPicUrl");
            return (Criteria) this;
        }

        public Criteria andItemPicUrlLessThanOrEqualTo(String value) {
            addCriterion("item_pic_url <=", value, "itemPicUrl");
            return (Criteria) this;
        }

        public Criteria andItemPicUrlLike(String value) {
            addCriterion("item_pic_url like", value, "itemPicUrl");
            return (Criteria) this;
        }

        public Criteria andItemPicUrlNotLike(String value) {
            addCriterion("item_pic_url not like", value, "itemPicUrl");
            return (Criteria) this;
        }

        public Criteria andItemPicUrlIn(List<String> values) {
            addCriterion("item_pic_url in", values, "itemPicUrl");
            return (Criteria) this;
        }

        public Criteria andItemPicUrlNotIn(List<String> values) {
            addCriterion("item_pic_url not in", values, "itemPicUrl");
            return (Criteria) this;
        }

        public Criteria andItemPicUrlBetween(String value1, String value2) {
            addCriterion("item_pic_url between", value1, value2, "itemPicUrl");
            return (Criteria) this;
        }

        public Criteria andItemPicUrlNotBetween(String value1, String value2) {
            addCriterion("item_pic_url not between", value1, value2, "itemPicUrl");
            return (Criteria) this;
        }

        public Criteria andSubtitleIsNull() {
            addCriterion("subtitle is null");
            return (Criteria) this;
        }

        public Criteria andSubtitleIsNotNull() {
            addCriterion("subtitle is not null");
            return (Criteria) this;
        }

        public Criteria andSubtitleEqualTo(String value) {
            addCriterion("subtitle =", value, "subtitle");
            return (Criteria) this;
        }

        public Criteria andSubtitleNotEqualTo(String value) {
            addCriterion("subtitle <>", value, "subtitle");
            return (Criteria) this;
        }

        public Criteria andSubtitleGreaterThan(String value) {
            addCriterion("subtitle >", value, "subtitle");
            return (Criteria) this;
        }

        public Criteria andSubtitleGreaterThanOrEqualTo(String value) {
            addCriterion("subtitle >=", value, "subtitle");
            return (Criteria) this;
        }

        public Criteria andSubtitleLessThan(String value) {
            addCriterion("subtitle <", value, "subtitle");
            return (Criteria) this;
        }

        public Criteria andSubtitleLessThanOrEqualTo(String value) {
            addCriterion("subtitle <=", value, "subtitle");
            return (Criteria) this;
        }

        public Criteria andSubtitleLike(String value) {
            addCriterion("subtitle like", value, "subtitle");
            return (Criteria) this;
        }

        public Criteria andSubtitleNotLike(String value) {
            addCriterion("subtitle not like", value, "subtitle");
            return (Criteria) this;
        }

        public Criteria andSubtitleIn(List<String> values) {
            addCriterion("subtitle in", values, "subtitle");
            return (Criteria) this;
        }

        public Criteria andSubtitleNotIn(List<String> values) {
            addCriterion("subtitle not in", values, "subtitle");
            return (Criteria) this;
        }

        public Criteria andSubtitleBetween(String value1, String value2) {
            addCriterion("subtitle between", value1, value2, "subtitle");
            return (Criteria) this;
        }

        public Criteria andSubtitleNotBetween(String value1, String value2) {
            addCriterion("subtitle not between", value1, value2, "subtitle");
            return (Criteria) this;
        }

        public Criteria andTopicCategoryIdIsNull() {
            addCriterion("topic_category_id is null");
            return (Criteria) this;
        }

        public Criteria andTopicCategoryIdIsNotNull() {
            addCriterion("topic_category_id is not null");
            return (Criteria) this;
        }

        public Criteria andTopicCategoryIdEqualTo(Integer value) {
            addCriterion("topic_category_id =", value, "topicCategoryId");
            return (Criteria) this;
        }

        public Criteria andTopicCategoryIdNotEqualTo(Integer value) {
            addCriterion("topic_category_id <>", value, "topicCategoryId");
            return (Criteria) this;
        }

        public Criteria andTopicCategoryIdGreaterThan(Integer value) {
            addCriterion("topic_category_id >", value, "topicCategoryId");
            return (Criteria) this;
        }

        public Criteria andTopicCategoryIdGreaterThanOrEqualTo(Integer value) {
            addCriterion("topic_category_id >=", value, "topicCategoryId");
            return (Criteria) this;
        }

        public Criteria andTopicCategoryIdLessThan(Integer value) {
            addCriterion("topic_category_id <", value, "topicCategoryId");
            return (Criteria) this;
        }

        public Criteria andTopicCategoryIdLessThanOrEqualTo(Integer value) {
            addCriterion("topic_category_id <=", value, "topicCategoryId");
            return (Criteria) this;
        }

        public Criteria andTopicCategoryIdIn(List<Integer> values) {
            addCriterion("topic_category_id in", values, "topicCategoryId");
            return (Criteria) this;
        }

        public Criteria andTopicCategoryIdNotIn(List<Integer> values) {
            addCriterion("topic_category_id not in", values, "topicCategoryId");
            return (Criteria) this;
        }

        public Criteria andTopicCategoryIdBetween(Integer value1, Integer value2) {
            addCriterion("topic_category_id between", value1, value2, "topicCategoryId");
            return (Criteria) this;
        }

        public Criteria andTopicCategoryIdNotBetween(Integer value1, Integer value2) {
            addCriterion("topic_category_id not between", value1, value2, "topicCategoryId");
            return (Criteria) this;
        }

        public Criteria andPriceInfoIsNull() {
            addCriterion("price_info is null");
            return (Criteria) this;
        }

        public Criteria andPriceInfoIsNotNull() {
            addCriterion("price_info is not null");
            return (Criteria) this;
        }

        public Criteria andPriceInfoEqualTo(BigDecimal value) {
            addCriterion("price_info =", value, "priceInfo");
            return (Criteria) this;
        }

        public Criteria andPriceInfoNotEqualTo(BigDecimal value) {
            addCriterion("price_info <>", value, "priceInfo");
            return (Criteria) this;
        }

        public Criteria andPriceInfoGreaterThan(BigDecimal value) {
            addCriterion("price_info >", value, "priceInfo");
            return (Criteria) this;
        }

        public Criteria andPriceInfoGreaterThanOrEqualTo(BigDecimal value) {
            addCriterion("price_info >=", value, "priceInfo");
            return (Criteria) this;
        }

        public Criteria andPriceInfoLessThan(BigDecimal value) {
            addCriterion("price_info <", value, "priceInfo");
            return (Criteria) this;
        }

        public Criteria andPriceInfoLessThanOrEqualTo(BigDecimal value) {
            addCriterion("price_info <=", value, "priceInfo");
            return (Criteria) this;
        }

        public Criteria andPriceInfoIn(List<BigDecimal> values) {
            addCriterion("price_info in", values, "priceInfo");
            return (Criteria) this;
        }

        public Criteria andPriceInfoNotIn(List<BigDecimal> values) {
            addCriterion("price_info not in", values, "priceInfo");
            return (Criteria) this;
        }

        public Criteria andPriceInfoBetween(BigDecimal value1, BigDecimal value2) {
            addCriterion("price_info between", value1, value2, "priceInfo");
            return (Criteria) this;
        }

        public Criteria andPriceInfoNotBetween(BigDecimal value1, BigDecimal value2) {
            addCriterion("price_info not between", value1, value2, "priceInfo");
            return (Criteria) this;
        }

        public Criteria andReadCountIsNull() {
            addCriterion("read_count is null");
            return (Criteria) this;
        }

        public Criteria andReadCountIsNotNull() {
            addCriterion("read_count is not null");
            return (Criteria) this;
        }

        public Criteria andReadCountEqualTo(String value) {
            addCriterion("read_count =", value, "readCount");
            return (Criteria) this;
        }

        public Criteria andReadCountNotEqualTo(String value) {
            addCriterion("read_count <>", value, "readCount");
            return (Criteria) this;
        }

        public Criteria andReadCountGreaterThan(String value) {
            addCriterion("read_count >", value, "readCount");
            return (Criteria) this;
        }

        public Criteria andReadCountGreaterThanOrEqualTo(String value) {
            addCriterion("read_count >=", value, "readCount");
            return (Criteria) this;
        }

        public Criteria andReadCountLessThan(String value) {
            addCriterion("read_count <", value, "readCount");
            return (Criteria) this;
        }

        public Criteria andReadCountLessThanOrEqualTo(String value) {
            addCriterion("read_count <=", value, "readCount");
            return (Criteria) this;
        }

        public Criteria andReadCountLike(String value) {
            addCriterion("read_count like", value, "readCount");
            return (Criteria) this;
        }

        public Criteria andReadCountNotLike(String value) {
            addCriterion("read_count not like", value, "readCount");
            return (Criteria) this;
        }

        public Criteria andReadCountIn(List<String> values) {
            addCriterion("read_count in", values, "readCount");
            return (Criteria) this;
        }

        public Criteria andReadCountNotIn(List<String> values) {
            addCriterion("read_count not in", values, "readCount");
            return (Criteria) this;
        }

        public Criteria andReadCountBetween(String value1, String value2) {
            addCriterion("read_count between", value1, value2, "readCount");
            return (Criteria) this;
        }

        public Criteria andReadCountNotBetween(String value1, String value2) {
            addCriterion("read_count not between", value1, value2, "readCount");
            return (Criteria) this;
        }

        public Criteria andScenePicUrlIsNull() {
            addCriterion("scene_pic_url is null");
            return (Criteria) this;
        }

        public Criteria andScenePicUrlIsNotNull() {
            addCriterion("scene_pic_url is not null");
            return (Criteria) this;
        }

        public Criteria andScenePicUrlEqualTo(String value) {
            addCriterion("scene_pic_url =", value, "scenePicUrl");
            return (Criteria) this;
        }

        public Criteria andScenePicUrlNotEqualTo(String value) {
            addCriterion("scene_pic_url <>", value, "scenePicUrl");
            return (Criteria) this;
        }

        public Criteria andScenePicUrlGreaterThan(String value) {
            addCriterion("scene_pic_url >", value, "scenePicUrl");
            return (Criteria) this;
        }

        public Criteria andScenePicUrlGreaterThanOrEqualTo(String value) {
            addCriterion("scene_pic_url >=", value, "scenePicUrl");
            return (Criteria) this;
        }

        public Criteria andScenePicUrlLessThan(String value) {
            addCriterion("scene_pic_url <", value, "scenePicUrl");
            return (Criteria) this;
        }

        public Criteria andScenePicUrlLessThanOrEqualTo(String value) {
            addCriterion("scene_pic_url <=", value, "scenePicUrl");
            return (Criteria) this;
        }

        public Criteria andScenePicUrlLike(String value) {
            addCriterion("scene_pic_url like", value, "scenePicUrl");
            return (Criteria) this;
        }

        public Criteria andScenePicUrlNotLike(String value) {
            addCriterion("scene_pic_url not like", value, "scenePicUrl");
            return (Criteria) this;
        }

        public Criteria andScenePicUrlIn(List<String> values) {
            addCriterion("scene_pic_url in", values, "scenePicUrl");
            return (Criteria) this;
        }

        public Criteria andScenePicUrlNotIn(List<String> values) {
            addCriterion("scene_pic_url not in", values, "scenePicUrl");
            return (Criteria) this;
        }

        public Criteria andScenePicUrlBetween(String value1, String value2) {
            addCriterion("scene_pic_url between", value1, value2, "scenePicUrl");
            return (Criteria) this;
        }

        public Criteria andScenePicUrlNotBetween(String value1, String value2) {
            addCriterion("scene_pic_url not between", value1, value2, "scenePicUrl");
            return (Criteria) this;
        }

        public Criteria andTopicTemplateIdIsNull() {
            addCriterion("topic_template_id is null");
            return (Criteria) this;
        }

        public Criteria andTopicTemplateIdIsNotNull() {
            addCriterion("topic_template_id is not null");
            return (Criteria) this;
        }

        public Criteria andTopicTemplateIdEqualTo(Integer value) {
            addCriterion("topic_template_id =", value, "topicTemplateId");
            return (Criteria) this;
        }

        public Criteria andTopicTemplateIdNotEqualTo(Integer value) {
            addCriterion("topic_template_id <>", value, "topicTemplateId");
            return (Criteria) this;
        }

        public Criteria andTopicTemplateIdGreaterThan(Integer value) {
            addCriterion("topic_template_id >", value, "topicTemplateId");
            return (Criteria) this;
        }

        public Criteria andTopicTemplateIdGreaterThanOrEqualTo(Integer value) {
            addCriterion("topic_template_id >=", value, "topicTemplateId");
            return (Criteria) this;
        }

        public Criteria andTopicTemplateIdLessThan(Integer value) {
            addCriterion("topic_template_id <", value, "topicTemplateId");
            return (Criteria) this;
        }

        public Criteria andTopicTemplateIdLessThanOrEqualTo(Integer value) {
            addCriterion("topic_template_id <=", value, "topicTemplateId");
            return (Criteria) this;
        }

        public Criteria andTopicTemplateIdIn(List<Integer> values) {
            addCriterion("topic_template_id in", values, "topicTemplateId");
            return (Criteria) this;
        }

        public Criteria andTopicTemplateIdNotIn(List<Integer> values) {
            addCriterion("topic_template_id not in", values, "topicTemplateId");
            return (Criteria) this;
        }

        public Criteria andTopicTemplateIdBetween(Integer value1, Integer value2) {
            addCriterion("topic_template_id between", value1, value2, "topicTemplateId");
            return (Criteria) this;
        }

        public Criteria andTopicTemplateIdNotBetween(Integer value1, Integer value2) {
            addCriterion("topic_template_id not between", value1, value2, "topicTemplateId");
            return (Criteria) this;
        }

        public Criteria andTopicTagIdIsNull() {
            addCriterion("topic_tag_id is null");
            return (Criteria) this;
        }

        public Criteria andTopicTagIdIsNotNull() {
            addCriterion("topic_tag_id is not null");
            return (Criteria) this;
        }

        public Criteria andTopicTagIdEqualTo(Integer value) {
            addCriterion("topic_tag_id =", value, "topicTagId");
            return (Criteria) this;
        }

        public Criteria andTopicTagIdNotEqualTo(Integer value) {
            addCriterion("topic_tag_id <>", value, "topicTagId");
            return (Criteria) this;
        }

        public Criteria andTopicTagIdGreaterThan(Integer value) {
            addCriterion("topic_tag_id >", value, "topicTagId");
            return (Criteria) this;
        }

        public Criteria andTopicTagIdGreaterThanOrEqualTo(Integer value) {
            addCriterion("topic_tag_id >=", value, "topicTagId");
            return (Criteria) this;
        }

        public Criteria andTopicTagIdLessThan(Integer value) {
            addCriterion("topic_tag_id <", value, "topicTagId");
            return (Criteria) this;
        }

        public Criteria andTopicTagIdLessThanOrEqualTo(Integer value) {
            addCriterion("topic_tag_id <=", value, "topicTagId");
            return (Criteria) this;
        }

        public Criteria andTopicTagIdIn(List<Integer> values) {
            addCriterion("topic_tag_id in", values, "topicTagId");
            return (Criteria) this;
        }

        public Criteria andTopicTagIdNotIn(List<Integer> values) {
            addCriterion("topic_tag_id not in", values, "topicTagId");
            return (Criteria) this;
        }

        public Criteria andTopicTagIdBetween(Integer value1, Integer value2) {
            addCriterion("topic_tag_id between", value1, value2, "topicTagId");
            return (Criteria) this;
        }

        public Criteria andTopicTagIdNotBetween(Integer value1, Integer value2) {
            addCriterion("topic_tag_id not between", value1, value2, "topicTagId");
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

        public Criteria andSortOrderEqualTo(Integer value) {
            addCriterion("sort_order =", value, "sortOrder");
            return (Criteria) this;
        }

        public Criteria andSortOrderNotEqualTo(Integer value) {
            addCriterion("sort_order <>", value, "sortOrder");
            return (Criteria) this;
        }

        public Criteria andSortOrderGreaterThan(Integer value) {
            addCriterion("sort_order >", value, "sortOrder");
            return (Criteria) this;
        }

        public Criteria andSortOrderGreaterThanOrEqualTo(Integer value) {
            addCriterion("sort_order >=", value, "sortOrder");
            return (Criteria) this;
        }

        public Criteria andSortOrderLessThan(Integer value) {
            addCriterion("sort_order <", value, "sortOrder");
            return (Criteria) this;
        }

        public Criteria andSortOrderLessThanOrEqualTo(Integer value) {
            addCriterion("sort_order <=", value, "sortOrder");
            return (Criteria) this;
        }

        public Criteria andSortOrderIn(List<Integer> values) {
            addCriterion("sort_order in", values, "sortOrder");
            return (Criteria) this;
        }

        public Criteria andSortOrderNotIn(List<Integer> values) {
            addCriterion("sort_order not in", values, "sortOrder");
            return (Criteria) this;
        }

        public Criteria andSortOrderBetween(Integer value1, Integer value2) {
            addCriterion("sort_order between", value1, value2, "sortOrder");
            return (Criteria) this;
        }

        public Criteria andSortOrderNotBetween(Integer value1, Integer value2) {
            addCriterion("sort_order not between", value1, value2, "sortOrder");
            return (Criteria) this;
        }

        public Criteria andIsShowIsNull() {
            addCriterion("is_show is null");
            return (Criteria) this;
        }

        public Criteria andIsShowIsNotNull() {
            addCriterion("is_show is not null");
            return (Criteria) this;
        }

        public Criteria andIsShowEqualTo(Boolean value) {
            addCriterion("is_show =", value, "isShow");
            return (Criteria) this;
        }

        public Criteria andIsShowNotEqualTo(Boolean value) {
            addCriterion("is_show <>", value, "isShow");
            return (Criteria) this;
        }

        public Criteria andIsShowGreaterThan(Boolean value) {
            addCriterion("is_show >", value, "isShow");
            return (Criteria) this;
        }

        public Criteria andIsShowGreaterThanOrEqualTo(Boolean value) {
            addCriterion("is_show >=", value, "isShow");
            return (Criteria) this;
        }

        public Criteria andIsShowLessThan(Boolean value) {
            addCriterion("is_show <", value, "isShow");
            return (Criteria) this;
        }

        public Criteria andIsShowLessThanOrEqualTo(Boolean value) {
            addCriterion("is_show <=", value, "isShow");
            return (Criteria) this;
        }

        public Criteria andIsShowIn(List<Boolean> values) {
            addCriterion("is_show in", values, "isShow");
            return (Criteria) this;
        }

        public Criteria andIsShowNotIn(List<Boolean> values) {
            addCriterion("is_show not in", values, "isShow");
            return (Criteria) this;
        }

        public Criteria andIsShowBetween(Boolean value1, Boolean value2) {
            addCriterion("is_show between", value1, value2, "isShow");
            return (Criteria) this;
        }

        public Criteria andIsShowNotBetween(Boolean value1, Boolean value2) {
            addCriterion("is_show not between", value1, value2, "isShow");
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