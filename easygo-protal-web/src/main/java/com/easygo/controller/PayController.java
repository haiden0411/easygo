package com.easygo.controller;

import com.easygo.api.PayClient;
import com.easygo.utils.IdWorker;
import com.easygo.utils.MessageResults;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import java.util.Map;

/**
 * Author：胡灯
 * Date：2020-10-05 21:44
 * Description：<描述>
 */
@Controller
@Scope("prototype")
public class PayController {
    @Autowired
    PayClient payClient;

    @RequestMapping("/pay")
    public String pay(Model model){
        IdWorker idWorker = new IdWorker();
        String out_trade_no = idWorker.nextId()+"";
        System.out.println("需要支付的订单编号是："+out_trade_no);
        Map<String,String> map = payClient.createNative(out_trade_no, "1");
        String code_url = map.get("code_url");
        Double total_fee = Double.valueOf(map.get("total_fee"));
        model.addAttribute("out_trade_no",out_trade_no);
        model.addAttribute("code_url",code_url);
        model.addAttribute("total_fee",total_fee);
        return "pay";
    }

    @RequestMapping("/queryPayStatus")
    @ResponseBody
    public MessageResults queryPayStatus(String out_trade_no){
        System.out.println("用户的订单编号是:"+out_trade_no);
        MessageResults results=new MessageResults(500,"支付失败");
        int count=0;
        while(true){
            System.out.println("--------->轮询微信支付接口,查询支付状态...........");
            //调用查询接口
            Map<String,String> map = payClient.queryPayStatus(out_trade_no);
            System.out.println("------>查询接口:"+map);
            if(map==null){
                results=new MessageResults(500,"微信接口异常");
                break;
            }
            if(map.get("trade_state").equals("SUCCESS")){
                System.out.println("支付成功");
                results=new MessageResults(200,"支付成功");
                break;
            }
            try {
                Thread.sleep(10000); //间隔4秒
            } catch (InterruptedException e) {
                e.printStackTrace();
            } finally {
            }
            count++;
            if(count>=100){
                results=new MessageResults(505,"二维码超时");
            }
        }
        return results;
    }

    /**
     * 支付成功跳转失败页面
     * @return
     */
    @RequestMapping("/payFail")
    public String payFail(){
        System.out.println("支付失败");
        return "payFail";
    }

    /**
     * 支付成功跳转成功页面
     * @param total_fee
     * @param model
     * @return
     */
    @RequestMapping("/paySuccess/{total_fee}")
    public String paySuccess(@PathVariable("total_fee") Double total_fee, Model model){
        System.out.println("支付成功");
        model.addAttribute("total_fee",total_fee);
        return "paySuccess";
    }
}
