.class public woSt_2.2.5_valid
.super java/lang/Object

.method public static __main()V
    .limit locals 0
    .limit stack 50
    return
.end method


.method public static foo(I)I
    .limit locals 3
    .limit stack 50
;       T1 := 1
    ldc 1
    istore 1
;       T2 := T0 I+ T1
    iload 0
    iload 1
    iadd
    istore 2
;       RETURN T2
    iload 2
    ireturn
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
    invokestatic woSt_2.2.5_valid/__main()V
    return
.end method

; standard initializer
.method public <init>()V
    aload_0
    invokenonvirtual java/lang/Object/<init>()V
    return
.end method