.class public factorial
.super java/lang/Object

.method public static factorial(I)I
    .limit locals 10
    .limit stack 50
;       T2 := 1
    ldc 1
    istore 2
;       T3 := T0 I== T2
    iload 0
    iload 2
    isub
    ifeq L_0
    ldc 0
    goto L_1
L_0:
    ldc 1
L_1:
    istore 3
;       T4 := Z! T3
    iload 3
    ifne L_2
    iconst_1
    goto L_3
L_2:
    iconst_0
L_3:
    istore 4
;       IF T4 GOTO L0
    iload 4
    ifne L0
;       T5 := 1
    ldc 1
    istore 5
;       T1 := T5
    iload 5
    istore 1
;       GOTO L1
    goto L1
;       L0:
L0:
;       T7 := 1
    ldc 1
    istore 7
;       T8 := T0 I- T7
    iload 0
    iload 7
    isub
    istore 8
;       T6 := CALL factorial(T8)
    iload 8
    invokestatic factorial/factorial(I)I
    istore 6
;       T9 := T0 I* T6
    iload 0
    iload 6
    imul
    istore 9
;       T1 := T9
    iload 9
    istore 1
;       L1:
L1:
;       RETURN T1
    iload 1
    ireturn
.end method


.method public static __main()V
    .limit locals 3
    .limit stack 50
;       T0 := "The factorial of 9 is "
    ldc "The factorial of 9 is "
    astore 0
;       PRINTU T0
    getstatic java/lang/System/out Ljava/io/PrintStream;
    aload 0
    invokevirtual java/io/PrintStream/print(Ljava/lang/String;)V
;       T2 := 9
    ldc 9
    istore 2
;       T1 := CALL factorial(T2)
    iload 2
    invokestatic factorial/factorial(I)I
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
    invokestatic factorial/__main()V
    return
.end method

; standard initializer
.method public <init>()V
    aload_0
    invokenonvirtual java/lang/Object/<init>()V
    return
.end method