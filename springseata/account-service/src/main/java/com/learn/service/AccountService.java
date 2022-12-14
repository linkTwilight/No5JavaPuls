package com.learn.service;

import com.baomidou.mybatisplus.extension.service.IService;
import com.learn.entity.Account;

public interface AccountService extends IService<Account> {
    public void debit(String userId, Integer money, String orderId);
}
