/*
 * This file is generated by jOOQ.
 */
package com.mysqljooq.assetmanageunit.jooq.domain.tables;


import com.mysqljooq.assetmanageunit.jooq.domain.Indexes;
import com.mysqljooq.assetmanageunit.jooq.domain.Jooqtest;
import com.mysqljooq.assetmanageunit.jooq.domain.Keys;
import com.mysqljooq.assetmanageunit.jooq.domain.tables.records.CommentsRecord;

import java.sql.Timestamp;
import java.util.Arrays;
import java.util.List;

import javax.annotation.Generated;

import org.jooq.Field;
import org.jooq.ForeignKey;
import org.jooq.Identity;
import org.jooq.Index;
import org.jooq.Name;
import org.jooq.Record;
import org.jooq.Schema;
import org.jooq.Table;
import org.jooq.TableField;
import org.jooq.UniqueKey;
import org.jooq.impl.DSL;
import org.jooq.impl.TableImpl;


/**
 * This class is generated by jOOQ.
 */
@Generated(
    value = {
        "http://www.jooq.org",
        "jOOQ version:3.11.9"
    },
    comments = "This class is generated by jOOQ"
)
@SuppressWarnings({ "all", "unchecked", "rawtypes" })
public class Comments extends TableImpl<CommentsRecord> {

    private static final long serialVersionUID = -616610757;

    /**
     * The reference instance of <code>jooqtest.COMMENTS</code>
     */
    public static final Comments COMMENTS = new Comments();

    /**
     * The class holding records for this type
     */
    @Override
    public Class<CommentsRecord> getRecordType() {
        return CommentsRecord.class;
    }

    /**
     * The column <code>jooqtest.COMMENTS.ID</code>.
     */
    public final TableField<CommentsRecord, Integer> ID = createField("ID", org.jooq.impl.SQLDataType.INTEGER.nullable(false).identity(true), this, "");

    /**
     * The column <code>jooqtest.COMMENTS.POST_ID</code>.
     */
    public final TableField<CommentsRecord, Integer> POST_ID = createField("POST_ID", org.jooq.impl.SQLDataType.INTEGER.nullable(false), this, "");

    /**
     * The column <code>jooqtest.COMMENTS.NAME</code>.
     */
    public final TableField<CommentsRecord, String> NAME = createField("NAME", org.jooq.impl.SQLDataType.VARCHAR(200).nullable(false), this, "");

    /**
     * The column <code>jooqtest.COMMENTS.EMAIL</code>.
     */
    public final TableField<CommentsRecord, String> EMAIL = createField("EMAIL", org.jooq.impl.SQLDataType.VARCHAR(200).nullable(false), this, "");

    /**
     * The column <code>jooqtest.COMMENTS.CONTENT</code>.
     */
    public final TableField<CommentsRecord, String> CONTENT = createField("CONTENT", org.jooq.impl.SQLDataType.CLOB, this, "");

    /**
     * The column <code>jooqtest.COMMENTS.CREATED_ON</code>.
     */
    public final TableField<CommentsRecord, Timestamp> CREATED_ON = createField("CREATED_ON", org.jooq.impl.SQLDataType.TIMESTAMP, this, "");

    /**
     * Create a <code>jooqtest.COMMENTS</code> table reference
     */
    public Comments() {
        this(DSL.name("COMMENTS"), null);
    }

    /**
     * Create an aliased <code>jooqtest.COMMENTS</code> table reference
     */
    public Comments(String alias) {
        this(DSL.name(alias), COMMENTS);
    }

    /**
     * Create an aliased <code>jooqtest.COMMENTS</code> table reference
     */
    public Comments(Name alias) {
        this(alias, COMMENTS);
    }

    private Comments(Name alias, Table<CommentsRecord> aliased) {
        this(alias, aliased, null);
    }

    private Comments(Name alias, Table<CommentsRecord> aliased, Field<?>[] parameters) {
        super(alias, null, aliased, parameters, DSL.comment(""));
    }

    public <O extends Record> Comments(Table<O> child, ForeignKey<O, CommentsRecord> key) {
        super(child, key, COMMENTS);
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public Schema getSchema() {
        return Jooqtest.JOOQTEST;
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public List<Index> getIndexes() {
        return Arrays.<Index>asList(Indexes.COMMENTS_PRIMARY);
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public Identity<CommentsRecord, Integer> getIdentity() {
        return Keys.IDENTITY_COMMENTS;
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public UniqueKey<CommentsRecord> getPrimaryKey() {
        return Keys.KEY_COMMENTS_PRIMARY;
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public List<UniqueKey<CommentsRecord>> getKeys() {
        return Arrays.<UniqueKey<CommentsRecord>>asList(Keys.KEY_COMMENTS_PRIMARY);
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public Comments as(String alias) {
        return new Comments(DSL.name(alias), this);
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public Comments as(Name alias) {
        return new Comments(alias, this);
    }

    /**
     * Rename this table
     */
    @Override
    public Comments rename(String name) {
        return new Comments(DSL.name(name), null);
    }

    /**
     * Rename this table
     */
    @Override
    public Comments rename(Name name) {
        return new Comments(name, null);
    }
}