package com.uzi.model;

import java.util.ArrayList;
import java.util.List;

public class OrdersExample {
    protected String orderByClause;

    protected boolean distinct;

    protected List<Criteria> oredCriteria;

    public OrdersExample() {
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

        public Criteria andOrdersidIsNull() {
            addCriterion("ORDERSID is null");
            return (Criteria) this;
        }

        public Criteria andOrdersidIsNotNull() {
            addCriterion("ORDERSID is not null");
            return (Criteria) this;
        }

        public Criteria andOrdersidEqualTo(Integer value) {
            addCriterion("ORDERSID =", value, "ordersid");
            return (Criteria) this;
        }

        public Criteria andOrdersidNotEqualTo(Integer value) {
            addCriterion("ORDERSID <>", value, "ordersid");
            return (Criteria) this;
        }

        public Criteria andOrdersidGreaterThan(Integer value) {
            addCriterion("ORDERSID >", value, "ordersid");
            return (Criteria) this;
        }

        public Criteria andOrdersidGreaterThanOrEqualTo(Integer value) {
            addCriterion("ORDERSID >=", value, "ordersid");
            return (Criteria) this;
        }

        public Criteria andOrdersidLessThan(Integer value) {
            addCriterion("ORDERSID <", value, "ordersid");
            return (Criteria) this;
        }

        public Criteria andOrdersidLessThanOrEqualTo(Integer value) {
            addCriterion("ORDERSID <=", value, "ordersid");
            return (Criteria) this;
        }

        public Criteria andOrdersidIn(List<Integer> values) {
            addCriterion("ORDERSID in", values, "ordersid");
            return (Criteria) this;
        }

        public Criteria andOrdersidNotIn(List<Integer> values) {
            addCriterion("ORDERSID not in", values, "ordersid");
            return (Criteria) this;
        }

        public Criteria andOrdersidBetween(Integer value1, Integer value2) {
            addCriterion("ORDERSID between", value1, value2, "ordersid");
            return (Criteria) this;
        }

        public Criteria andOrdersidNotBetween(Integer value1, Integer value2) {
            addCriterion("ORDERSID not between", value1, value2, "ordersid");
            return (Criteria) this;
        }

        public Criteria andUseridIsNull() {
            addCriterion("USERID is null");
            return (Criteria) this;
        }

        public Criteria andUseridIsNotNull() {
            addCriterion("USERID is not null");
            return (Criteria) this;
        }

        public Criteria andUseridEqualTo(Integer value) {
            addCriterion("USERID =", value, "userid");
            return (Criteria) this;
        }

        public Criteria andUseridNotEqualTo(Integer value) {
            addCriterion("USERID <>", value, "userid");
            return (Criteria) this;
        }

        public Criteria andUseridGreaterThan(Integer value) {
            addCriterion("USERID >", value, "userid");
            return (Criteria) this;
        }

        public Criteria andUseridGreaterThanOrEqualTo(Integer value) {
            addCriterion("USERID >=", value, "userid");
            return (Criteria) this;
        }

        public Criteria andUseridLessThan(Integer value) {
            addCriterion("USERID <", value, "userid");
            return (Criteria) this;
        }

        public Criteria andUseridLessThanOrEqualTo(Integer value) {
            addCriterion("USERID <=", value, "userid");
            return (Criteria) this;
        }

        public Criteria andUseridIn(List<Integer> values) {
            addCriterion("USERID in", values, "userid");
            return (Criteria) this;
        }

        public Criteria andUseridNotIn(List<Integer> values) {
            addCriterion("USERID not in", values, "userid");
            return (Criteria) this;
        }

        public Criteria andUseridBetween(Integer value1, Integer value2) {
            addCriterion("USERID between", value1, value2, "userid");
            return (Criteria) this;
        }

        public Criteria andUseridNotBetween(Integer value1, Integer value2) {
            addCriterion("USERID not between", value1, value2, "userid");
            return (Criteria) this;
        }

        public Criteria andIsoverIsNull() {
            addCriterion("ISOVER is null");
            return (Criteria) this;
        }

        public Criteria andIsoverIsNotNull() {
            addCriterion("ISOVER is not null");
            return (Criteria) this;
        }

        public Criteria andIsoverEqualTo(Integer value) {
            addCriterion("ISOVER =", value, "isover");
            return (Criteria) this;
        }

        public Criteria andIsoverNotEqualTo(Integer value) {
            addCriterion("ISOVER <>", value, "isover");
            return (Criteria) this;
        }

        public Criteria andIsoverGreaterThan(Integer value) {
            addCriterion("ISOVER >", value, "isover");
            return (Criteria) this;
        }

        public Criteria andIsoverGreaterThanOrEqualTo(Integer value) {
            addCriterion("ISOVER >=", value, "isover");
            return (Criteria) this;
        }

        public Criteria andIsoverLessThan(Integer value) {
            addCriterion("ISOVER <", value, "isover");
            return (Criteria) this;
        }

        public Criteria andIsoverLessThanOrEqualTo(Integer value) {
            addCriterion("ISOVER <=", value, "isover");
            return (Criteria) this;
        }

        public Criteria andIsoverIn(List<Integer> values) {
            addCriterion("ISOVER in", values, "isover");
            return (Criteria) this;
        }

        public Criteria andIsoverNotIn(List<Integer> values) {
            addCriterion("ISOVER not in", values, "isover");
            return (Criteria) this;
        }

        public Criteria andIsoverBetween(Integer value1, Integer value2) {
            addCriterion("ISOVER between", value1, value2, "isover");
            return (Criteria) this;
        }

        public Criteria andIsoverNotBetween(Integer value1, Integer value2) {
            addCriterion("ISOVER not between", value1, value2, "isover");
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