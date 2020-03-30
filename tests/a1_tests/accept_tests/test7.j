.class public test7
.super java/lang/Object

.method public static factorial(I)I
    .limit locals 9
    .limit stack 50
;       T1 := 1
    ldc 1
    istore 1
;       T2 := T0 I== T1
    iload 0
    iload 1
    isub
    ifeq L_0
    ldc 0
    goto L_1
L_0:
    ldc 1
L_1:
    istore 2
;       T3 := Z! T2
    iload 2
    ifne L_2
    iconst_1
    goto L_3
L_2:
    iconst_0
L_3:
    istore 3
;       IF T3 GOTO L0
    iload 3
    ifne L0
;       T4 := 1
    ldc 1
    istore 4
;       RETURN T4
    iload 4
    ireturn
;       GOTO L1
    goto L1
;       L0:
L0:
;       T6 := 1
    ldc 1
    istore 6
;       T7 := T0 I- T6
    iload 0
    iload 6
    isub
    istore 7
;       T5 := CALL factorial(T7)
    iload 7
    invokestatic test7/factorial(I)I
    istore 5
;       T8 := T0 I* T5
    iload 0
    iload 5
    imul
    istore 8
;       RETURN T8
    iload 8
    ireturn
;       L1:
L1:
    return
.end method


.method public static __main()V
    .limit locals 3
    .limit stack 50
;       T0 := "The factorial of 8 is "
    ldc "The factorial of 8 is "
    astore 0
;       PRINTU T0
    getstatic java/lang/System/out Ljava/io/PrintStream;
    aload 0
    invokevirtual java/io/PrintStream/print(Ljava/lang/String;)V
;       T2 := 8
    ldc 8
    istore 2
;       T1 := CALL factorial(T2)
    iload 2
    invokestatic test7/factorial(I)I
    istore 1
;       PRINTLNI T1
    getstatic java/lang/System/out Ljava/io/PrintStream;
    iload 1
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
    invokestatic test7/__main()V
    return
.end method

; standard initializer
.method public <init>()V
    aload_0
    invokenonvirtual java/lang/Object/<init>()V
    return
.end method