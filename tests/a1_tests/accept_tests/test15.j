.class public test15
.super java/lang/Object

.method public static num_digits_on_rhs(F)I
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
    .limit locals 10
    .limit stack 50
;       T1 := NEWARRAY U 3
    ldc 3
    anewarray java/lang/String
    astore 1
;       T2 := NEWARRAY U 3
    ldc 3
    anewarray java/lang/String
    astore 2
;       T3 := 34643.234
    ldc 34643.234
    fstore 3
;       T0 := T3
    fload 3
    fstore 0
;       T4 := CALL num_digits_on_rhs(T0)
    fload 0
    invokestatic test15/num_digits_on_rhs(F)I
    istore 4
;       PRINTLNI T4
    getstatic java/lang/System/out Ljava/io/PrintStream;
    iload 4
    invokevirtual java/io/PrintStream/println(I)V
;       T5 := 1
    ldc 1
    istore 5
;       T6 := T2[T5]
    aload 2
    iload 5
    aaload
    astore 6
;       T7 := 2
    ldc 2
    istore 7
;       T8 := T1[T7]
    aload 1
    iload 7
    aaload
    astore 8
;       T9 := T6 U+ T8
    new java/lang/StringBuilder
    dup
    invokespecial java/lang/StringBuilder/<init>()V
    aload 6
    invokevirtual java/lang/StringBuilder.append(Ljava/lang/String;)Ljava/lang/StringBuilder;
    aload 8
    invokevirtual java/lang/StringBuilder.append(Ljava/lang/String;)Ljava/lang/StringBuilder;
    invokevirtual java/lang/StringBuilder.toString()Ljava/lang/String;
    astore 9
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
    invokestatic test15/__main()V
    return
.end method

; standard initializer
.method public <init>()V
    aload_0
    invokenonvirtual java/lang/Object/<init>()V
    return
.end method