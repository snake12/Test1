package org.example;

public class PageBuilder {

        public static LoginPage buildLoginPage() {
            return new LoginPage("/login");
        }



//        public static BalancePage buildBalancePage() {
//            DepositForm depositForm = new DepositForm();
//            WithdrawalForm withdrawalForm = new WithdrawalForm();
//            return new BalancePage("/balance", depositForm, withdrawalForm);
//        }
}
