package com.content.train.enums;

/**
 * Created by shawxy on 8/2/16.
 */
public enum BehaviorType {



    BEHAVIOR_TYPE_READ(1),
    BEHAVIOR_TYPE_SEARCH(2),
    BEHAVIOR_TYPE_COMMIT(3),
    BEHAVIOR_TYPE_LIKE(4),
    BEHAVIOR_TYPE_REPLY(5),
    BEHAVIOR_TYPE_FAVOURIT(6),
    BEHAVIOR_TYPE_UNLIKE(7),
    BEHAVIOR_TYPE_UNFAVOURIT(8),
    BEHAVIOR_TYPE_SHARE(9)
    ;

    int typeCode;

    private BehaviorType(int typeCode){
         this.typeCode = typeCode;
    }

    public static boolean isPositiveBehavior(int code){

        if(code != BEHAVIOR_TYPE_UNLIKE.typeCode && code != BEHAVIOR_TYPE_UNFAVOURIT.typeCode){

            return true;
        }
        return false;

    }

}
