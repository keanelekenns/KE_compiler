.class public woSt_3.1_valid
.super java/lang/Object

.method public static __main()V
    .limit locals 12
    .limit stack 50
;       T3 := TRUE
    ldc 1
    istore 3
;       T4 := Z! T3
    iload 3
    ifne L_0
    iconst_1
    goto L_1
L_0:
    iconst_0
L_1:
    istore 4
;       IF T4 GOTO L0
    iload 4
    ifne L0
;       T5 := "true if statement"
    ldc "true if statement"
    astore 5
;       PRINTU T5
    getstatic java/lang/System/out Ljava/io/PrintStream;
    aload 5
    invokevirtual java/io/PrintStream/print(Ljava/lang/String;)V
;       L0:
L0:
;       T6 := TRUE
    ldc 1
    istore 6
;       T0 := T6
    iload 6
    istore 0
;       L1:
L1:
;       T7 := Z! T0
    iload 0
    ifne L_2
    iconst_1
    goto L_3
L_2:
    iconst_0
L_3:
    istore 7
;       IF T7 GOTO L2
    iload 7
    ifne L2
;       T8 := "looping while once"
    ldc "looping while once"
    astore 8
;       PRINTU T8
    getstatic java/lang/System/out Ljava/io/PrintStream;
    aload 8
    invokevirtual java/io/PrintStream/print(Ljava/lang/String;)V
;       T9 := FALSE
    ldc 0
    istore 9
;       T0 := T9
    iload 9
    istore 0
;       GOTO L1
    goto L1
;       L2:
L2:
;       T10 := 5
    ldc 5
    istore 10
;       PRINTI T10
    getstatic java/lang/System/out Ljava/io/PrintStream;
    iload 10
    invokevirtual java/io/PrintStream/print(I)V
;       T11 := "new line"
    ldc "new line"
    astore 11
;       PRINTLNU T11
    getstatic java/lang/System/out Ljava/io/PrintStream;
    aload 11
    invokevirtual java/io/PrintStream/println(Ljava/lang/String;)V
;       T2 := T1
    iload 1
    istore 2
    return
.end method


.method public static foo()I
    .limit locals 2
    .limit stack 50
;       T1 := 5
    ldc 5
    istore 1
;       T0 := T1
    iload 1
    istore 0
;       RETURN T0
    iload 0
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
    invokestatic woSt_3.1_valid/__main()V
    return
.end method

; standard initializer
.method public <init>()V
    aload_0
    invokenonvirtual java/lang/Object/<init>()V
    return
.end method