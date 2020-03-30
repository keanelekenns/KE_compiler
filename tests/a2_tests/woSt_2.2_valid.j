.class public woSt_2.2_valid
.super java/lang/Object

.method public static __main()V
    .limit locals 7
    .limit stack 50
;       T3 := 2
    ldc 2
    istore 3
;       T4 := 2
    ldc 2
    istore 4
;       T5 := 9
    ldc 9
    istore 5
;       T2 := CALL sum(T3T4T5)
    iload 3
    iload 4
    iload 5
    invokestatic woSt_2.2_valid/sum(III)I
    istore 2
;       T6 := 2
    ldc 2
    istore 6
;       T1 := CALL mult(T2T6)
    iload 2
    iload 6
    invokestatic woSt_2.2_valid/mult(II)I
    istore 1
;       T0 := T1
    iload 1
    istore 0
    return
.end method


.method public static sum(III)I
    .limit locals 4
    .limit stack 50
;       T3 := T0 I+ T1
    iload 0
    iload 1
    iadd
    istore 3
;       T2 := T3
    iload 3
    istore 2
;       RETURN T2
    iload 2
    ireturn
.end method


.method public static mult(II)I
    .limit locals 4
    .limit stack 50
;       T3 := T0 I* T1
    iload 0
    iload 1
    imul
    istore 3
;       T2 := T3
    iload 3
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
    invokestatic woSt_2.2_valid/__main()V
    return
.end method

; standard initializer
.method public <init>()V
    aload_0
    invokenonvirtual java/lang/Object/<init>()V
    return
.end method