/**
 * Autogenerated by Thrift Compiler (0.11.0)
 *
 * DO NOT EDIT UNLESS YOU ARE SURE THAT YOU KNOW WHAT YOU ARE DOING
 *  @generated
 */
package com.jiayoo.thrift.generated;

@SuppressWarnings({"cast", "rawtypes", "serial", "unchecked", "unused"})
@javax.annotation.Generated(value = "Autogenerated by Thrift Compiler (0.11.0)", date = "2019-01-03")
public class Friend implements org.apache.thrift.TBase<Friend, Friend._Fields>, java.io.Serializable, Cloneable, Comparable<Friend> {
  private static final org.apache.thrift.protocol.TStruct STRUCT_DESC = new org.apache.thrift.protocol.TStruct("Friend");

  private static final org.apache.thrift.protocol.TField I_COUNT_FIELD_DESC = new org.apache.thrift.protocol.TField("i_count", org.apache.thrift.protocol.TType.STRING, (short)1);
  private static final org.apache.thrift.protocol.TField Y_COUNT_FIELD_DESC = new org.apache.thrift.protocol.TField("y_count", org.apache.thrift.protocol.TType.STRING, (short)2);

  private static final org.apache.thrift.scheme.SchemeFactory STANDARD_SCHEME_FACTORY = new FriendStandardSchemeFactory();
  private static final org.apache.thrift.scheme.SchemeFactory TUPLE_SCHEME_FACTORY = new FriendTupleSchemeFactory();

  public String i_count; // optional
  public String y_count; // optional

  /** The set of fields this struct contains, along with convenience methods for finding and manipulating them. */
  public enum _Fields implements org.apache.thrift.TFieldIdEnum {
    I_COUNT((short)1, "i_count"),
    Y_COUNT((short)2, "y_count");

    private static final java.util.Map<String, _Fields> byName = new java.util.HashMap<String, _Fields>();

    static {
      for (_Fields field : java.util.EnumSet.allOf(_Fields.class)) {
        byName.put(field.getFieldName(), field);
      }
    }

    /**
     * Find the _Fields constant that matches fieldId, or null if its not found.
     */
    public static _Fields findByThriftId(int fieldId) {
      switch(fieldId) {
        case 1: // I_COUNT
          return I_COUNT;
        case 2: // Y_COUNT
          return Y_COUNT;
        default:
          return null;
      }
    }

    /**
     * Find the _Fields constant that matches fieldId, throwing an exception
     * if it is not found.
     */
    public static _Fields findByThriftIdOrThrow(int fieldId) {
      _Fields fields = findByThriftId(fieldId);
      if (fields == null) throw new IllegalArgumentException("Field " + fieldId + " doesn't exist!");
      return fields;
    }

    /**
     * Find the _Fields constant that matches name, or null if its not found.
     */
    public static _Fields findByName(String name) {
      return byName.get(name);
    }

    private final short _thriftId;
    private final String _fieldName;

    _Fields(short thriftId, String fieldName) {
      _thriftId = thriftId;
      _fieldName = fieldName;
    }

    public short getThriftFieldId() {
      return _thriftId;
    }

    public String getFieldName() {
      return _fieldName;
    }
  }

  // isset id assignments
  private static final _Fields optionals[] = {_Fields.I_COUNT,_Fields.Y_COUNT};
  public static final java.util.Map<_Fields, org.apache.thrift.meta_data.FieldMetaData> metaDataMap;
  static {
    java.util.Map<_Fields, org.apache.thrift.meta_data.FieldMetaData> tmpMap = new java.util.EnumMap<_Fields, org.apache.thrift.meta_data.FieldMetaData>(_Fields.class);
    tmpMap.put(_Fields.I_COUNT, new org.apache.thrift.meta_data.FieldMetaData("i_count", org.apache.thrift.TFieldRequirementType.OPTIONAL, 
        new org.apache.thrift.meta_data.FieldValueMetaData(org.apache.thrift.protocol.TType.STRING        , "String")));
    tmpMap.put(_Fields.Y_COUNT, new org.apache.thrift.meta_data.FieldMetaData("y_count", org.apache.thrift.TFieldRequirementType.OPTIONAL, 
        new org.apache.thrift.meta_data.FieldValueMetaData(org.apache.thrift.protocol.TType.STRING        , "String")));
    metaDataMap = java.util.Collections.unmodifiableMap(tmpMap);
    org.apache.thrift.meta_data.FieldMetaData.addStructMetaDataMap(Friend.class, metaDataMap);
  }

  public Friend() {
  }

  /**
   * Performs a deep copy on <i>other</i>.
   */
  public Friend(Friend other) {
    if (other.isSetI_count()) {
      this.i_count = other.i_count;
    }
    if (other.isSetY_count()) {
      this.y_count = other.y_count;
    }
  }

  public Friend deepCopy() {
    return new Friend(this);
  }

  @Override
  public void clear() {
    this.i_count = null;
    this.y_count = null;
  }

  public String getI_count() {
    return this.i_count;
  }

  public Friend setI_count(String i_count) {
    this.i_count = i_count;
    return this;
  }

  public void unsetI_count() {
    this.i_count = null;
  }

  /** Returns true if field i_count is set (has been assigned a value) and false otherwise */
  public boolean isSetI_count() {
    return this.i_count != null;
  }

  public void setI_countIsSet(boolean value) {
    if (!value) {
      this.i_count = null;
    }
  }

  public String getY_count() {
    return this.y_count;
  }

  public Friend setY_count(String y_count) {
    this.y_count = y_count;
    return this;
  }

  public void unsetY_count() {
    this.y_count = null;
  }

  /** Returns true if field y_count is set (has been assigned a value) and false otherwise */
  public boolean isSetY_count() {
    return this.y_count != null;
  }

  public void setY_countIsSet(boolean value) {
    if (!value) {
      this.y_count = null;
    }
  }

  public void setFieldValue(_Fields field, Object value) {
    switch (field) {
    case I_COUNT:
      if (value == null) {
        unsetI_count();
      } else {
        setI_count((String)value);
      }
      break;

    case Y_COUNT:
      if (value == null) {
        unsetY_count();
      } else {
        setY_count((String)value);
      }
      break;

    }
  }

  public Object getFieldValue(_Fields field) {
    switch (field) {
    case I_COUNT:
      return getI_count();

    case Y_COUNT:
      return getY_count();

    }
    throw new IllegalStateException();
  }

  /** Returns true if field corresponding to fieldID is set (has been assigned a value) and false otherwise */
  public boolean isSet(_Fields field) {
    if (field == null) {
      throw new IllegalArgumentException();
    }

    switch (field) {
    case I_COUNT:
      return isSetI_count();
    case Y_COUNT:
      return isSetY_count();
    }
    throw new IllegalStateException();
  }

  @Override
  public boolean equals(Object that) {
    if (that == null)
      return false;
    if (that instanceof Friend)
      return this.equals((Friend)that);
    return false;
  }

  public boolean equals(Friend that) {
    if (that == null)
      return false;
    if (this == that)
      return true;

    boolean this_present_i_count = true && this.isSetI_count();
    boolean that_present_i_count = true && that.isSetI_count();
    if (this_present_i_count || that_present_i_count) {
      if (!(this_present_i_count && that_present_i_count))
        return false;
      if (!this.i_count.equals(that.i_count))
        return false;
    }

    boolean this_present_y_count = true && this.isSetY_count();
    boolean that_present_y_count = true && that.isSetY_count();
    if (this_present_y_count || that_present_y_count) {
      if (!(this_present_y_count && that_present_y_count))
        return false;
      if (!this.y_count.equals(that.y_count))
        return false;
    }

    return true;
  }

  @Override
  public int hashCode() {
    int hashCode = 1;

    hashCode = hashCode * 8191 + ((isSetI_count()) ? 131071 : 524287);
    if (isSetI_count())
      hashCode = hashCode * 8191 + i_count.hashCode();

    hashCode = hashCode * 8191 + ((isSetY_count()) ? 131071 : 524287);
    if (isSetY_count())
      hashCode = hashCode * 8191 + y_count.hashCode();

    return hashCode;
  }

  @Override
  public int compareTo(Friend other) {
    if (!getClass().equals(other.getClass())) {
      return getClass().getName().compareTo(other.getClass().getName());
    }

    int lastComparison = 0;

    lastComparison = Boolean.valueOf(isSetI_count()).compareTo(other.isSetI_count());
    if (lastComparison != 0) {
      return lastComparison;
    }
    if (isSetI_count()) {
      lastComparison = org.apache.thrift.TBaseHelper.compareTo(this.i_count, other.i_count);
      if (lastComparison != 0) {
        return lastComparison;
      }
    }
    lastComparison = Boolean.valueOf(isSetY_count()).compareTo(other.isSetY_count());
    if (lastComparison != 0) {
      return lastComparison;
    }
    if (isSetY_count()) {
      lastComparison = org.apache.thrift.TBaseHelper.compareTo(this.y_count, other.y_count);
      if (lastComparison != 0) {
        return lastComparison;
      }
    }
    return 0;
  }

  public _Fields fieldForId(int fieldId) {
    return _Fields.findByThriftId(fieldId);
  }

  public void read(org.apache.thrift.protocol.TProtocol iprot) throws org.apache.thrift.TException {
    scheme(iprot).read(iprot, this);
  }

  public void write(org.apache.thrift.protocol.TProtocol oprot) throws org.apache.thrift.TException {
    scheme(oprot).write(oprot, this);
  }

  @Override
  public String toString() {
    StringBuilder sb = new StringBuilder("Friend(");
    boolean first = true;

    if (isSetI_count()) {
      sb.append("i_count:");
      if (this.i_count == null) {
        sb.append("null");
      } else {
        sb.append(this.i_count);
      }
      first = false;
    }
    if (isSetY_count()) {
      if (!first) sb.append(", ");
      sb.append("y_count:");
      if (this.y_count == null) {
        sb.append("null");
      } else {
        sb.append(this.y_count);
      }
      first = false;
    }
    sb.append(")");
    return sb.toString();
  }

  public void validate() throws org.apache.thrift.TException {
    // check for required fields
    // check for sub-struct validity
  }

  private void writeObject(java.io.ObjectOutputStream out) throws java.io.IOException {
    try {
      write(new org.apache.thrift.protocol.TCompactProtocol(new org.apache.thrift.transport.TIOStreamTransport(out)));
    } catch (org.apache.thrift.TException te) {
      throw new java.io.IOException(te);
    }
  }

  private void readObject(java.io.ObjectInputStream in) throws java.io.IOException, ClassNotFoundException {
    try {
      read(new org.apache.thrift.protocol.TCompactProtocol(new org.apache.thrift.transport.TIOStreamTransport(in)));
    } catch (org.apache.thrift.TException te) {
      throw new java.io.IOException(te);
    }
  }

  private static class FriendStandardSchemeFactory implements org.apache.thrift.scheme.SchemeFactory {
    public FriendStandardScheme getScheme() {
      return new FriendStandardScheme();
    }
  }

  private static class FriendStandardScheme extends org.apache.thrift.scheme.StandardScheme<Friend> {

    public void read(org.apache.thrift.protocol.TProtocol iprot, Friend struct) throws org.apache.thrift.TException {
      org.apache.thrift.protocol.TField schemeField;
      iprot.readStructBegin();
      while (true)
      {
        schemeField = iprot.readFieldBegin();
        if (schemeField.type == org.apache.thrift.protocol.TType.STOP) { 
          break;
        }
        switch (schemeField.id) {
          case 1: // I_COUNT
            if (schemeField.type == org.apache.thrift.protocol.TType.STRING) {
              struct.i_count = iprot.readString();
              struct.setI_countIsSet(true);
            } else { 
              org.apache.thrift.protocol.TProtocolUtil.skip(iprot, schemeField.type);
            }
            break;
          case 2: // Y_COUNT
            if (schemeField.type == org.apache.thrift.protocol.TType.STRING) {
              struct.y_count = iprot.readString();
              struct.setY_countIsSet(true);
            } else { 
              org.apache.thrift.protocol.TProtocolUtil.skip(iprot, schemeField.type);
            }
            break;
          default:
            org.apache.thrift.protocol.TProtocolUtil.skip(iprot, schemeField.type);
        }
        iprot.readFieldEnd();
      }
      iprot.readStructEnd();

      // check for required fields of primitive type, which can't be checked in the validate method
      struct.validate();
    }

    public void write(org.apache.thrift.protocol.TProtocol oprot, Friend struct) throws org.apache.thrift.TException {
      struct.validate();

      oprot.writeStructBegin(STRUCT_DESC);
      if (struct.i_count != null) {
        if (struct.isSetI_count()) {
          oprot.writeFieldBegin(I_COUNT_FIELD_DESC);
          oprot.writeString(struct.i_count);
          oprot.writeFieldEnd();
        }
      }
      if (struct.y_count != null) {
        if (struct.isSetY_count()) {
          oprot.writeFieldBegin(Y_COUNT_FIELD_DESC);
          oprot.writeString(struct.y_count);
          oprot.writeFieldEnd();
        }
      }
      oprot.writeFieldStop();
      oprot.writeStructEnd();
    }

  }

  private static class FriendTupleSchemeFactory implements org.apache.thrift.scheme.SchemeFactory {
    public FriendTupleScheme getScheme() {
      return new FriendTupleScheme();
    }
  }

  private static class FriendTupleScheme extends org.apache.thrift.scheme.TupleScheme<Friend> {

    @Override
    public void write(org.apache.thrift.protocol.TProtocol prot, Friend struct) throws org.apache.thrift.TException {
      org.apache.thrift.protocol.TTupleProtocol oprot = (org.apache.thrift.protocol.TTupleProtocol) prot;
      java.util.BitSet optionals = new java.util.BitSet();
      if (struct.isSetI_count()) {
        optionals.set(0);
      }
      if (struct.isSetY_count()) {
        optionals.set(1);
      }
      oprot.writeBitSet(optionals, 2);
      if (struct.isSetI_count()) {
        oprot.writeString(struct.i_count);
      }
      if (struct.isSetY_count()) {
        oprot.writeString(struct.y_count);
      }
    }

    @Override
    public void read(org.apache.thrift.protocol.TProtocol prot, Friend struct) throws org.apache.thrift.TException {
      org.apache.thrift.protocol.TTupleProtocol iprot = (org.apache.thrift.protocol.TTupleProtocol) prot;
      java.util.BitSet incoming = iprot.readBitSet(2);
      if (incoming.get(0)) {
        struct.i_count = iprot.readString();
        struct.setI_countIsSet(true);
      }
      if (incoming.get(1)) {
        struct.y_count = iprot.readString();
        struct.setY_countIsSet(true);
      }
    }
  }

  private static <S extends org.apache.thrift.scheme.IScheme> S scheme(org.apache.thrift.protocol.TProtocol proto) {
    return (org.apache.thrift.scheme.StandardScheme.class.equals(proto.getScheme()) ? STANDARD_SCHEME_FACTORY : TUPLE_SCHEME_FACTORY).getScheme();
  }
}

