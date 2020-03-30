.class public test5
.super java/lang/Object

.method public static __main()V
    .limit locals 8
    .limit stack 50
;       T1 := "HELLO WORLD!"
    ldc "HELLO WORLD!"
    astore 1
;       PRINTLNU T1
    getstatic java/lang/System/out Ljava/io/PrintStream;
    aload 1
    invokevirtual java/io/PrintStream/println(Ljava/lang/String;)V
;       T2 := "Countdown:"
    ldc "Countdown:"
    astore 2
;       PRINTLNU T2
    getstatic java/lang/System/out Ljava/io/PrintStream;
    aload 2
    invokevirtual java/io/PrintStream/println(Ljava/lang/String;)V
;       T3 := 10
    ldc 10
    istore 3
;       T0 := T3
    iload 3
    istore 0
;       L0:
L0:
;       T4 := 0
    ldc 0
    istore 4
;       T5 := T4 I< T0
    iload 4
    iload 0
    isub
    iflt L_0
    ldc 0
    goto L_1
L_0:
    ldc 1
L_1:
    istore 5
;       T6 := Z! T5
    iload 5
    ifne L_2
    iconst_1
    goto L_3
L_2:
    iconst_0
L_3:
    istore 6
;       IF T6 GOTO L1
    iload 6
    ifne L1
;       PRINTLNI T0
    getstatic java/lang/System/out Ljava/io/PrintStream;
    iload 0
    invokevirtual java/io/PrintStream/println(I)V
;       GOTO L0
    goto L0
;       L1:
L1:
;       T7 := "BLAST OFF!!!"
    ldc "BLAST OFF!!!"
    astore 7
;       PRINTLNU T7
    getstatic java/lang/System/out Ljava/io/PrintStream;
    aload 7
    invokevirtual java/io/PrintStream/println(Ljava/lang/String;)V
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
    invokestatic test5/__main()V
    return
.end method

; standard initializer
.method public <init>()V
    aload_0
    invokenonvirtual java/lang/Object/<init>()V
    return
.end method