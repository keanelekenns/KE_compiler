.class public woSt_2.1_valid
.super java/lang/Object

.method public static __main()V
    .limit locals 0
    .limit stack 50
    return
.end method


.method public static foo1(F)I
    .limit locals 1
    .limit stack 50
    return
.end method


.method public static foo2(F)I
    .limit locals 1
    .limit stack 50
    return
.end method


;--------------------------------------------;
;                                            ;
; Boilerplate                                ;
;                                            ;
;--------------------------------------------;
.method public static main([Ljava/lang/String;)V
    ; set limits used by this method
    .limit locals 1
    .limit stack 4
    invokestatic woSt_2.1_valid/__main()V
    return
.end method

; standard initializer
.method public <init>()V
    aload_0
    invokenonvirtual java/lang/Object/<init>()V
    return
.end method