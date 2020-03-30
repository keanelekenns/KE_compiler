.class public test4
.super java/lang/Object

.method public static num_digits_on_lhs(F)I
    .limit locals 10
    .limit stack 50
;       T2 := 0
    ldc 0
    istore 2
;       T1 := T2
    iload 2
    istore 1
;       L0:
L0:
;       T3 := 1.0
    ldc 1.0
    fstore 3
;       T4 := T3 F< T0
    fload 3
    fload 0
    fcmpl
    iflt L_0
    ldc 0
    goto L_1
L_0:
    ldc 1
L_1:
    istore 4
;       T5 := Z! T4
    iload 4
    ifne L_2
    iconst_1
    goto L_3
L_2:
    iconst_0
L_3:
    istore 5
;       IF T5 GOTO L1
    iload 5
    ifne L1
;       T6 := 1
    ldc 1
    istore 6
;       T7 := T1 I+ T6
    iload 1
    iload 6
    iadd
    istore 7
;       T1 := T7
    iload 7
    istore 1
;       T8 := 0.1
    ldc 0.1
    fstore 8
;       T9 := T0 F* T8
    fload 0
    fload 8
    fmul
    fstore 9
;       T0 := T9
    fload 9
    fstore 0
;       GOTO L0
    goto L0
;       L1:
L1:
;       RETURN T1
    iload 1
    ireturn
.end method


.method public static __main()V
    .limit locals 3
    .limit stack 50
;       T1 := 34643.234
    ldc 34643.234
    fstore 1
;       T0 := T1
    fload 1
    fstore 0
;       T2 := CALL num_digits_on_lhs(T0)
    fload 0
    invokestatic test4/num_digits_on_lhs(F)I
    istore 2
;       PRINTLNI T2
    getstatic java/lang/System/out Ljava/io/PrintStream;
    iload 2
    invokevirtual java/io/PrintStream/println(I)V
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
    invokestatic test4/__main()V
    return
.end method

; standard initializer
.method public <init>()V
    aload_0
    invokenonvirtual java/lang/Object/<init>()V
    return
.end method