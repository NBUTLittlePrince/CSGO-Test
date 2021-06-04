package com.csgo.service;

import com.csgo.dao.moneychargeMapper;
import com.csgo.po.moneycharge;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service("moneyChargeService")
public class MoneyChargeServiceImpl implements MoneyChargeService{
    @Autowired
    moneychargeMapper moneychargeMapper;
    @Override
    public int updateMoneyCharge(moneycharge moneycharge) {

        moneycharge moneycharge1=moneychargeMapper.selectByPrimaryKey(moneycharge.getChargeid());

        if(moneycharge1!=null)
        {
            if(moneycharge1.getIschecked()==0) {
                moneycharge1.setIschecked(1);
                moneychargeMapper.updateByPrimaryKey(moneycharge1);
                return 1;
            }
        }

            return 0;

    }
}
