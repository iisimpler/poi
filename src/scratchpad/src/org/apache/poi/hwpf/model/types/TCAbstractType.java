
/* ====================================================================
 * The Apache Software License, Version 1.1
 *
 * Copyright (c) 2003 The Apache Software Foundation.  All rights
 * reserved.
 *
 * Redistribution and use in source and binary forms, with or without
 * modification, are permitted provided that the following conditions
 * are met:
 *
 * 1. Redistributions of source code must retain the above copyright
 *    notice, this list of conditions and the following disclaimer.
 *
 * 2. Redistributions in binary form must reproduce the above copyright
 *    notice, this list of conditions and the following disclaimer in
 *    the documentation and/or other materials provided with the
 *    distribution.
 *
 * 3. The end-user documentation included with the redistribution,
 *    if any, must include the following acknowledgment:
 *       "This product includes software developed by the
 *        Apache Software Foundation (http://www.apache.org/)."
 *    Alternately, this acknowledgment may appear in the software itself,
 *    if and wherever such third-party acknowledgments normally appear.
 *
 * 4. The names "Apache" and "Apache Software Foundation" and
 *    "Apache POI" must not be used to endorse or promote products
 *    derived from this software without prior written permission. For
 *    written permission, please contact apache@apache.org.
 *
 * 5. Products derived from this software may not be called "Apache",
 *    "Apache POI", nor may "Apache" appear in their name, without
 *    prior written permission of the Apache Software Foundation.
 *
 * THIS SOFTWARE IS PROVIDED ``AS IS'' AND ANY EXPRESSED OR IMPLIED
 * WARRANTIES, INCLUDING, BUT NOT LIMITED TO, THE IMPLIED WARRANTIES
 * OF MERCHANTABILITY AND FITNESS FOR A PARTICULAR PURPOSE ARE
 * DISCLAIMED.  IN NO EVENT SHALL THE APACHE SOFTWARE FOUNDATION OR
 * ITS CONTRIBUTORS BE LIABLE FOR ANY DIRECT, INDIRECT, INCIDENTAL,
 * SPECIAL, EXEMPLARY, OR CONSEQUENTIAL DAMAGES (INCLUDING, BUT NOT
 * LIMITED TO, PROCUREMENT OF SUBSTITUTE GOODS OR SERVICES; LOSS OF
 * USE, DATA, OR PROFITS; OR BUSINESS INTERRUPTION) HOWEVER CAUSED AND
 * ON ANY THEORY OF LIABILITY, WHETHER IN CONTRACT, STRICT LIABILITY,
 * OR TORT (INCLUDING NEGLIGENCE OR OTHERWISE) ARISING IN ANY WAY OUT
 * OF THE USE OF THIS SOFTWARE, EVEN IF ADVISED OF THE POSSIBILITY OF
 * SUCH DAMAGE.
 * ====================================================================
 *
 * This software consists of voluntary contributions made by many
 * individuals on behalf of the Apache Software Foundation.  For more
 * information on the Apache Software Foundation, please see
 * <http://www.apache.org/>.
 */


package org.apache.poi.hwpf.model.types;



import org.apache.poi.util.BitField;
import org.apache.poi.util.LittleEndian;
import org.apache.poi.util.StringUtil;
import org.apache.poi.util.HexDump;
import org.apache.poi.hdf.model.hdftypes.HDFType;
import org.apache.poi.hwpf.usermodel.*;

/**
 * Table Cell Descriptor.
 * NOTE: This source is automatically generated please do not modify this file.  Either subclass or
 *       remove the record in src/records/definitions.

 * @author S. Ryan Ackley
 */
public abstract class TCAbstractType
    implements HDFType
{

    protected  short field_1_rgf;
        private static BitField  fFirstMerged = new BitField(0x0001);
        private static BitField  fMerged = new BitField(0x0002);
        private static BitField  fVertical = new BitField(0x0004);
        private static BitField  fBackward = new BitField(0x0008);
        private static BitField  fRotateFont = new BitField(0x0010);
        private static BitField  fVertMerge = new BitField(0x0020);
        private static BitField  fVertRestart = new BitField(0x0040);
        private static BitField  vertAlign = new BitField(0x0180);
    protected  short field_2_unused;
    protected  BorderCode field_3_brcTop;
    protected  BorderCode field_4_brcLeft;
    protected  BorderCode field_5_brcBottom;
    protected  BorderCode field_6_brcRight;


    public TCAbstractType()
    {

    }

    protected void fillFields(byte [] data, int offset)
    {
        field_1_rgf                     = LittleEndian.getShort(data, 0x0 + offset);
        field_2_unused                  = LittleEndian.getShort(data, 0x2 + offset);
        field_3_brcTop                  = new BorderCode(data, 0x4 + offset);
        field_4_brcLeft                 = new BorderCode(data, 0x8 + offset);
        field_5_brcBottom               = new BorderCode(data, 0xc + offset);
        field_6_brcRight                = new BorderCode(data, 0x10 + offset);

    }

    public void serialize(byte[] data, int offset)
    {
        LittleEndian.putShort(data, 0x0 + offset, (short)field_1_rgf);;
        LittleEndian.putShort(data, 0x2 + offset, (short)field_2_unused);;
        field_3_brcTop.serialize(data, 0x4 + offset);;
        field_4_brcLeft.serialize(data, 0x8 + offset);;
        field_5_brcBottom.serialize(data, 0xc + offset);;
        field_6_brcRight.serialize(data, 0x10 + offset);;

    }

    public String toString()
    {
        StringBuffer buffer = new StringBuffer();

        buffer.append("[TC]\n");

        buffer.append("    .rgf                  = ");
        buffer.append(" (").append(getRgf()).append(" )\n");
        buffer.append("         .fFirstMerged             = ").append(isFFirstMerged()).append('\n');
        buffer.append("         .fMerged                  = ").append(isFMerged()).append('\n');
        buffer.append("         .fVertical                = ").append(isFVertical()).append('\n');
        buffer.append("         .fBackward                = ").append(isFBackward()).append('\n');
        buffer.append("         .fRotateFont              = ").append(isFRotateFont()).append('\n');
        buffer.append("         .fVertMerge               = ").append(isFVertMerge()).append('\n');
        buffer.append("         .fVertRestart             = ").append(isFVertRestart()).append('\n');
        buffer.append("         .vertAlign                = ").append(getVertAlign()).append('\n');

        buffer.append("    .unused               = ");
        buffer.append(" (").append(getUnused()).append(" )\n");

        buffer.append("    .brcTop               = ");
        buffer.append(" (").append(getBrcTop()).append(" )\n");

        buffer.append("    .brcLeft              = ");
        buffer.append(" (").append(getBrcLeft()).append(" )\n");

        buffer.append("    .brcBottom            = ");
        buffer.append(" (").append(getBrcBottom()).append(" )\n");

        buffer.append("    .brcRight             = ");
        buffer.append(" (").append(getBrcRight()).append(" )\n");

        buffer.append("[/TC]\n");
        return buffer.toString();
    }

    /**
     * Size of record (exluding 4 byte header)
     */
    public int getSize()
    {
        return 4 +  + 2 + 2 + 4 + 4 + 4 + 4;
    }



    /**
     * Get the rgf field for the TC record.
     */
    public short getRgf()
    {
        return field_1_rgf;
    }

    /**
     * Set the rgf field for the TC record.
     */
    public void setRgf(short field_1_rgf)
    {
        this.field_1_rgf = field_1_rgf;
    }

    /**
     * Get the unused field for the TC record.
     */
    public short getUnused()
    {
        return field_2_unused;
    }

    /**
     * Set the unused field for the TC record.
     */
    public void setUnused(short field_2_unused)
    {
        this.field_2_unused = field_2_unused;
    }

    /**
     * Get the brcTop field for the TC record.
     */
    public BorderCode getBrcTop()
    {
        return field_3_brcTop;
    }

    /**
     * Set the brcTop field for the TC record.
     */
    public void setBrcTop(BorderCode field_3_brcTop)
    {
        this.field_3_brcTop = field_3_brcTop;
    }

    /**
     * Get the brcLeft field for the TC record.
     */
    public BorderCode getBrcLeft()
    {
        return field_4_brcLeft;
    }

    /**
     * Set the brcLeft field for the TC record.
     */
    public void setBrcLeft(BorderCode field_4_brcLeft)
    {
        this.field_4_brcLeft = field_4_brcLeft;
    }

    /**
     * Get the brcBottom field for the TC record.
     */
    public BorderCode getBrcBottom()
    {
        return field_5_brcBottom;
    }

    /**
     * Set the brcBottom field for the TC record.
     */
    public void setBrcBottom(BorderCode field_5_brcBottom)
    {
        this.field_5_brcBottom = field_5_brcBottom;
    }

    /**
     * Get the brcRight field for the TC record.
     */
    public BorderCode getBrcRight()
    {
        return field_6_brcRight;
    }

    /**
     * Set the brcRight field for the TC record.
     */
    public void setBrcRight(BorderCode field_6_brcRight)
    {
        this.field_6_brcRight = field_6_brcRight;
    }

    /**
     * Sets the fFirstMerged field value.
     * 
     */
    public void setFFirstMerged(boolean value)
    {
        field_1_rgf = (short)fFirstMerged.setBoolean(field_1_rgf, value);

        
    }

    /**
     * 
     * @return  the fFirstMerged field value.
     */
    public boolean isFFirstMerged()
    {
        return fFirstMerged.isSet(field_1_rgf);
        
    }

    /**
     * Sets the fMerged field value.
     * 
     */
    public void setFMerged(boolean value)
    {
        field_1_rgf = (short)fMerged.setBoolean(field_1_rgf, value);

        
    }

    /**
     * 
     * @return  the fMerged field value.
     */
    public boolean isFMerged()
    {
        return fMerged.isSet(field_1_rgf);
        
    }

    /**
     * Sets the fVertical field value.
     * 
     */
    public void setFVertical(boolean value)
    {
        field_1_rgf = (short)fVertical.setBoolean(field_1_rgf, value);

        
    }

    /**
     * 
     * @return  the fVertical field value.
     */
    public boolean isFVertical()
    {
        return fVertical.isSet(field_1_rgf);
        
    }

    /**
     * Sets the fBackward field value.
     * 
     */
    public void setFBackward(boolean value)
    {
        field_1_rgf = (short)fBackward.setBoolean(field_1_rgf, value);

        
    }

    /**
     * 
     * @return  the fBackward field value.
     */
    public boolean isFBackward()
    {
        return fBackward.isSet(field_1_rgf);
        
    }

    /**
     * Sets the fRotateFont field value.
     * 
     */
    public void setFRotateFont(boolean value)
    {
        field_1_rgf = (short)fRotateFont.setBoolean(field_1_rgf, value);

        
    }

    /**
     * 
     * @return  the fRotateFont field value.
     */
    public boolean isFRotateFont()
    {
        return fRotateFont.isSet(field_1_rgf);
        
    }

    /**
     * Sets the fVertMerge field value.
     * 
     */
    public void setFVertMerge(boolean value)
    {
        field_1_rgf = (short)fVertMerge.setBoolean(field_1_rgf, value);

        
    }

    /**
     * 
     * @return  the fVertMerge field value.
     */
    public boolean isFVertMerge()
    {
        return fVertMerge.isSet(field_1_rgf);
        
    }

    /**
     * Sets the fVertRestart field value.
     * 
     */
    public void setFVertRestart(boolean value)
    {
        field_1_rgf = (short)fVertRestart.setBoolean(field_1_rgf, value);

        
    }

    /**
     * 
     * @return  the fVertRestart field value.
     */
    public boolean isFVertRestart()
    {
        return fVertRestart.isSet(field_1_rgf);
        
    }

    /**
     * Sets the vertAlign field value.
     * 
     */
    public void setVertAlign(byte value)
    {
        field_1_rgf = (short)vertAlign.setValue(field_1_rgf, value);

        
    }

    /**
     * 
     * @return  the vertAlign field value.
     */
    public byte getVertAlign()
    {
        return ( byte )vertAlign.getValue(field_1_rgf);
        
    }


}  // END OF CLASS




