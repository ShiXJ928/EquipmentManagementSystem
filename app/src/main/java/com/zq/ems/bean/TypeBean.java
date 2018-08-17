package com.zq.ems.bean;

import java.util.List;

/**
 * Created by SXJ on 2018/8/14 10:31
 * E-Mail Address：2394905398@qq.com
 */

public class TypeBean {

//    [{"name1":"大类1","list":[{"name2":"小类12","list":[{"name3":"类型111"},
// {"name3":"类型112"},{"name3":"类型113"},{"name3":"类型114"}]},{"name2":"小类12","list":
// [{"name3":"类型121"},{"name3":"类型122"},{"name3":"类型123"},{"name3":"类型124"}]}]},
// {"name1":"大类1","list":[{"name2":"小类12","list":[{"name3":"类型111"},{"name3":"类型112"},
// {"name3":"类型113"},{"name3":"类型114"}]},{"name2":"小类12","list":[{"name3":"类型121"},
// {"name3":"类型122"},{"name3":"类型123"},{"name3":"类型124"}]}]},
// {"name1":"大类2","list":[{"name2":"小类22","list":[{"name3":"类型211"},
// {"name3":"类型212"},{"name3":"类型213"},{"name3":"类型214"}]},{"name2":"小类22","list":[{"name3":"类型221"},
// {"name3":"类型222"},{"name3":"类型223"},{"name3":"类型224"}]}]}]
    /**
     * name1 : 大类1
     * list : [{"name2":"小类11","list":[{"name3":"类型111"}]}]
     */

    private String name1;
    private List<ListBeanX> list;

    public String getName1() {
        return name1;
    }

    public void setName1(String name1) {
        this.name1 = name1;
    }

    public List<ListBeanX> getList() {
        return list;
    }

    public void setList(List<ListBeanX> list) {
        this.list = list;
    }

    public static class ListBeanX {
        /**
         * name2 : 小类11
         * list : [{"name3":"类型111"}]
         */

        private String name2;
        private List<ListBean> list;

        public String getName2() {
            return name2;
        }

        public void setName2(String name2) {
            this.name2 = name2;
        }

        public List<ListBean> getList() {
            return list;
        }

        public void setList(List<ListBean> list) {
            this.list = list;
        }

        public static class ListBean {
            /**
             * name3 : 类型111
             */

            private String name3;

            public String getName3() {
                return name3;
            }

            public void setName3(String name3) {
                this.name3 = name3;
            }
        }
    }
}
