package com.uzi.model;

import java.util.ArrayList;
import java.util.List;

public class GoodsExample {
    protected String orderByClause;

    protected boolean distinct;

    protected List<Criteria> oredCriteria;

    public GoodsExample() {
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

        public Criteria andGoodsidIsNull() {
            addCriterion("GOODSID is null");
            return (Criteria) this;
        }

        public Criteria andGoodsidIsNotNull() {
            addCriterion("GOODSID is not null");
            return (Criteria) this;
        }

        public Criteria andGoodsidEqualTo(Integer value) {
            addCriterion("GOODSID =", value, "goodsid");
            return (Criteria) this;
        }

        public Criteria andGoodsidNotEqualTo(Integer value) {
            addCriterion("GOODSID <>", value, "goodsid");
            return (Criteria) this;
        }

        public Criteria andGoodsidGreaterThan(Integer value) {
            addCriterion("GOODSID >", value, "goodsid");
            return (Criteria) this;
        }

        public Criteria andGoodsidGreaterThanOrEqualTo(Integer value) {
            addCriterion("GOODSID >=", value, "goodsid");
            return (Criteria) this;
        }

        public Criteria andGoodsidLessThan(Integer value) {
            addCriterion("GOODSID <", value, "goodsid");
            return (Criteria) this;
        }

        public Criteria andGoodsidLessThanOrEqualTo(Integer value) {
            addCriterion("GOODSID <=", value, "goodsid");
            return (Criteria) this;
        }

        public Criteria andGoodsidIn(List<Integer> values) {
            addCriterion("GOODSID in", values, "goodsid");
            return (Criteria) this;
        }

        public Criteria andGoodsidNotIn(List<Integer> values) {
            addCriterion("GOODSID not in", values, "goodsid");
            return (Criteria) this;
        }

        public Criteria andGoodsidBetween(Integer value1, Integer value2) {
            addCriterion("GOODSID between", value1, value2, "goodsid");
            return (Criteria) this;
        }

        public Criteria andGoodsidNotBetween(Integer value1, Integer value2) {
            addCriterion("GOODSID not between", value1, value2, "goodsid");
            return (Criteria) this;
        }

        public Criteria andGoodsnameIsNull() {
            addCriterion("GOODSNAME is null");
            return (Criteria) this;
        }

        public Criteria andGoodsnameIsNotNull() {
            addCriterion("GOODSNAME is not null");
            return (Criteria) this;
        }

        public Criteria andGoodsnameEqualTo(String value) {
            addCriterion("GOODSNAME =", value, "goodsname");
            return (Criteria) this;
        }

        public Criteria andGoodsnameNotEqualTo(String value) {
            addCriterion("GOODSNAME <>", value, "goodsname");
            return (Criteria) this;
        }

        public Criteria andGoodsnameGreaterThan(String value) {
            addCriterion("GOODSNAME >", value, "goodsname");
            return (Criteria) this;
        }

        public Criteria andGoodsnameGreaterThanOrEqualTo(String value) {
            addCriterion("GOODSNAME >=", value, "goodsname");
            return (Criteria) this;
        }

        public Criteria andGoodsnameLessThan(String value) {
            addCriterion("GOODSNAME <", value, "goodsname");
            return (Criteria) this;
        }

        public Criteria andGoodsnameLessThanOrEqualTo(String value) {
            addCriterion("GOODSNAME <=", value, "goodsname");
            return (Criteria) this;
        }

        public Criteria andGoodsnameLike(String value) {
            addCriterion("GOODSNAME like", value, "goodsname");
            return (Criteria) this;
        }

        public Criteria andGoodsnameNotLike(String value) {
            addCriterion("GOODSNAME not like", value, "goodsname");
            return (Criteria) this;
        }

        public Criteria andGoodsnameIn(List<String> values) {
            addCriterion("GOODSNAME in", values, "goodsname");
            return (Criteria) this;
        }

        public Criteria andGoodsnameNotIn(List<String> values) {
            addCriterion("GOODSNAME not in", values, "goodsname");
            return (Criteria) this;
        }

        public Criteria andGoodsnameBetween(String value1, String value2) {
            addCriterion("GOODSNAME between", value1, value2, "goodsname");
            return (Criteria) this;
        }

        public Criteria andGoodsnameNotBetween(String value1, String value2) {
            addCriterion("GOODSNAME not between", value1, value2, "goodsname");
            return (Criteria) this;
        }

        public Criteria andGoodsimgIsNull() {
            addCriterion("GOODSIMG is null");
            return (Criteria) this;
        }

        public Criteria andGoodsimgIsNotNull() {
            addCriterion("GOODSIMG is not null");
            return (Criteria) this;
        }

        public Criteria andGoodsimgEqualTo(String value) {
            addCriterion("GOODSIMG =", value, "goodsimg");
            return (Criteria) this;
        }

        public Criteria andGoodsimgNotEqualTo(String value) {
            addCriterion("GOODSIMG <>", value, "goodsimg");
            return (Criteria) this;
        }

        public Criteria andGoodsimgGreaterThan(String value) {
            addCriterion("GOODSIMG >", value, "goodsimg");
            return (Criteria) this;
        }

        public Criteria andGoodsimgGreaterThanOrEqualTo(String value) {
            addCriterion("GOODSIMG >=", value, "goodsimg");
            return (Criteria) this;
        }

        public Criteria andGoodsimgLessThan(String value) {
            addCriterion("GOODSIMG <", value, "goodsimg");
            return (Criteria) this;
        }

        public Criteria andGoodsimgLessThanOrEqualTo(String value) {
            addCriterion("GOODSIMG <=", value, "goodsimg");
            return (Criteria) this;
        }

        public Criteria andGoodsimgLike(String value) {
            addCriterion("GOODSIMG like", value, "goodsimg");
            return (Criteria) this;
        }

        public Criteria andGoodsimgNotLike(String value) {
            addCriterion("GOODSIMG not like", value, "goodsimg");
            return (Criteria) this;
        }

        public Criteria andGoodsimgIn(List<String> values) {
            addCriterion("GOODSIMG in", values, "goodsimg");
            return (Criteria) this;
        }

        public Criteria andGoodsimgNotIn(List<String> values) {
            addCriterion("GOODSIMG not in", values, "goodsimg");
            return (Criteria) this;
        }

        public Criteria andGoodsimgBetween(String value1, String value2) {
            addCriterion("GOODSIMG between", value1, value2, "goodsimg");
            return (Criteria) this;
        }

        public Criteria andGoodsimgNotBetween(String value1, String value2) {
            addCriterion("GOODSIMG not between", value1, value2, "goodsimg");
            return (Criteria) this;
        }

        public Criteria andGoodspriceIsNull() {
            addCriterion("GOODSPRICE is null");
            return (Criteria) this;
        }

        public Criteria andGoodspriceIsNotNull() {
            addCriterion("GOODSPRICE is not null");
            return (Criteria) this;
        }

        public Criteria andGoodspriceEqualTo(Integer value) {
            addCriterion("GOODSPRICE =", value, "goodsprice");
            return (Criteria) this;
        }

        public Criteria andGoodspriceNotEqualTo(Integer value) {
            addCriterion("GOODSPRICE <>", value, "goodsprice");
            return (Criteria) this;
        }

        public Criteria andGoodspriceGreaterThan(Integer value) {
            addCriterion("GOODSPRICE >", value, "goodsprice");
            return (Criteria) this;
        }

        public Criteria andGoodspriceGreaterThanOrEqualTo(Integer value) {
            addCriterion("GOODSPRICE >=", value, "goodsprice");
            return (Criteria) this;
        }

        public Criteria andGoodspriceLessThan(Integer value) {
            addCriterion("GOODSPRICE <", value, "goodsprice");
            return (Criteria) this;
        }

        public Criteria andGoodspriceLessThanOrEqualTo(Integer value) {
            addCriterion("GOODSPRICE <=", value, "goodsprice");
            return (Criteria) this;
        }

        public Criteria andGoodspriceIn(List<Integer> values) {
            addCriterion("GOODSPRICE in", values, "goodsprice");
            return (Criteria) this;
        }

        public Criteria andGoodspriceNotIn(List<Integer> values) {
            addCriterion("GOODSPRICE not in", values, "goodsprice");
            return (Criteria) this;
        }

        public Criteria andGoodspriceBetween(Integer value1, Integer value2) {
            addCriterion("GOODSPRICE between", value1, value2, "goodsprice");
            return (Criteria) this;
        }

        public Criteria andGoodspriceNotBetween(Integer value1, Integer value2) {
            addCriterion("GOODSPRICE not between", value1, value2, "goodsprice");
            return (Criteria) this;
        }

        public Criteria andGoodsinfoIsNull() {
            addCriterion("GOODSINFO is null");
            return (Criteria) this;
        }

        public Criteria andGoodsinfoIsNotNull() {
            addCriterion("GOODSINFO is not null");
            return (Criteria) this;
        }

        public Criteria andGoodsinfoEqualTo(String value) {
            addCriterion("GOODSINFO =", value, "goodsinfo");
            return (Criteria) this;
        }

        public Criteria andGoodsinfoNotEqualTo(String value) {
            addCriterion("GOODSINFO <>", value, "goodsinfo");
            return (Criteria) this;
        }

        public Criteria andGoodsinfoGreaterThan(String value) {
            addCriterion("GOODSINFO >", value, "goodsinfo");
            return (Criteria) this;
        }

        public Criteria andGoodsinfoGreaterThanOrEqualTo(String value) {
            addCriterion("GOODSINFO >=", value, "goodsinfo");
            return (Criteria) this;
        }

        public Criteria andGoodsinfoLessThan(String value) {
            addCriterion("GOODSINFO <", value, "goodsinfo");
            return (Criteria) this;
        }

        public Criteria andGoodsinfoLessThanOrEqualTo(String value) {
            addCriterion("GOODSINFO <=", value, "goodsinfo");
            return (Criteria) this;
        }

        public Criteria andGoodsinfoLike(String value) {
            addCriterion("GOODSINFO like", value, "goodsinfo");
            return (Criteria) this;
        }

        public Criteria andGoodsinfoNotLike(String value) {
            addCriterion("GOODSINFO not like", value, "goodsinfo");
            return (Criteria) this;
        }

        public Criteria andGoodsinfoIn(List<String> values) {
            addCriterion("GOODSINFO in", values, "goodsinfo");
            return (Criteria) this;
        }

        public Criteria andGoodsinfoNotIn(List<String> values) {
            addCriterion("GOODSINFO not in", values, "goodsinfo");
            return (Criteria) this;
        }

        public Criteria andGoodsinfoBetween(String value1, String value2) {
            addCriterion("GOODSINFO between", value1, value2, "goodsinfo");
            return (Criteria) this;
        }

        public Criteria andGoodsinfoNotBetween(String value1, String value2) {
            addCriterion("GOODSINFO not between", value1, value2, "goodsinfo");
            return (Criteria) this;
        }

        public Criteria andGoodsnumIsNull() {
            addCriterion("GOODSNUM is null");
            return (Criteria) this;
        }

        public Criteria andGoodsnumIsNotNull() {
            addCriterion("GOODSNUM is not null");
            return (Criteria) this;
        }

        public Criteria andGoodsnumEqualTo(Integer value) {
            addCriterion("GOODSNUM =", value, "goodsnum");
            return (Criteria) this;
        }

        public Criteria andGoodsnumNotEqualTo(Integer value) {
            addCriterion("GOODSNUM <>", value, "goodsnum");
            return (Criteria) this;
        }

        public Criteria andGoodsnumGreaterThan(Integer value) {
            addCriterion("GOODSNUM >", value, "goodsnum");
            return (Criteria) this;
        }

        public Criteria andGoodsnumGreaterThanOrEqualTo(Integer value) {
            addCriterion("GOODSNUM >=", value, "goodsnum");
            return (Criteria) this;
        }

        public Criteria andGoodsnumLessThan(Integer value) {
            addCriterion("GOODSNUM <", value, "goodsnum");
            return (Criteria) this;
        }

        public Criteria andGoodsnumLessThanOrEqualTo(Integer value) {
            addCriterion("GOODSNUM <=", value, "goodsnum");
            return (Criteria) this;
        }

        public Criteria andGoodsnumIn(List<Integer> values) {
            addCriterion("GOODSNUM in", values, "goodsnum");
            return (Criteria) this;
        }

        public Criteria andGoodsnumNotIn(List<Integer> values) {
            addCriterion("GOODSNUM not in", values, "goodsnum");
            return (Criteria) this;
        }

        public Criteria andGoodsnumBetween(Integer value1, Integer value2) {
            addCriterion("GOODSNUM between", value1, value2, "goodsnum");
            return (Criteria) this;
        }

        public Criteria andGoodsnumNotBetween(Integer value1, Integer value2) {
            addCriterion("GOODSNUM not between", value1, value2, "goodsnum");
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