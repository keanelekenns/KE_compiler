.class public woSt_3.3_valid
.super java/lang/Object

.method public static __main()V
    .limit locals 4
    .limit stack 50
;       T2 := 3
    ldc 3
    istore 2
;       T0 := T2
    iload 2
    istore 0
;       T3 := 4
    ldc 4
    istore 3
;       T1 := T3
    iload 3
    istore 1
;       CALL foo(T0T1)
    iload 0
    iload 1
    invokestatic woSt_3.3_valid/foo(II)V
    return
.end method


.method public static foo(II)V
    .limit locals 2
    .limit stack 50
;       PRINTI T0
    getstatic java/lang/System/out Ljava/io/PrintStream;
    iload 0
    invokevirtual java/io/PrintStream/print(I)V
;       PRINTI T1
    getstatic java/lang/System/out Ljava/io/PrintStream;
    iload 1
    invokevirtual java/io/PrintStream/print(I)V
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
    invokestatic woSt_3.3_valid/__main()V
    return
.end method

; standard initializer
.method public <init>()V
    aload_0
    invokenonvirtual java/lang/Object/<init>()V
    return
.end method