package com.comdosoft.financial.user.domain.zhangfu;

public class GoodCardType {
    /**
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database column good_card_types.id
     *
     * @mbggenerated
     */
    private Integer id;

    /**
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database column good_card_types.good_id
     *
     * @mbggenerated
     */
    private Integer goodId;

    /**
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database column good_card_types.card_type_id
     *
     * @mbggenerated
     */
    private Integer cardTypeId;

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column good_card_types.id
     *
     * @return the value of good_card_types.id
     *
     * @mbggenerated
     */
    public Integer getId() {
        return id;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column good_card_types.id
     *
     * @param id the value for good_card_types.id
     *
     * @mbggenerated
     */
    public void setId(Integer id) {
        this.id = id;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column good_card_types.good_id
     *
     * @return the value of good_card_types.good_id
     *
     * @mbggenerated
     */
    public Integer getGoodId() {
        return goodId;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column good_card_types.good_id
     *
     * @param goodId the value for good_card_types.good_id
     *
     * @mbggenerated
     */
    public void setGoodId(Integer goodId) {
        this.goodId = goodId;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column good_card_types.card_type_id
     *
     * @return the value of good_card_types.card_type_id
     *
     * @mbggenerated
     */
    public Integer getCardTypeId() {
        return cardTypeId;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column good_card_types.card_type_id
     *
     * @param cardTypeId the value for good_card_types.card_type_id
     *
     * @mbggenerated
     */
    public void setCardTypeId(Integer cardTypeId) {
        this.cardTypeId = cardTypeId;
    }
}